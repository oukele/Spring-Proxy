# Spring-Proxy
静态代理和动态代理的简单示例

#### 简单代理
~~~
    //cheater 就是一个代理对象
    //因为它是受student 委托 完成某些功能
    //它要完成的主要功能，来自student
    //除了委托的事情，可能还会拓展一些行为
    Student student = new Student();
    Cheater cheater = new Cheater(student);
    cheater.exam();
    
    -----------------------------------------------------
    
    Examable e = new Student();
    e.exam();//原来的行为
    System.out.println("-----------------------代理的行为-----------------------");
    Examable cheater = new Cheater(e);
    cheater.exam();//代理的行为
    
    运行结果：
    
    完成考试了。。。
    -----------------------代理的行为-----------------------
    唱了一首歌，差点被劝退
    完成考试了。。。
    但是忘记写了名字
~~~
#### 静态代理
~~~
public interface Exam {//考试的接口
    void exam();
}

public class Student implements Exam {
    
    public void exam(){
        System.out.println("奋笔疾书，完成考试啦");
    }
}

public class Cheater implements Exam {
　　//被代理的对象
    private final Exam student;

    public Cheater(Exam student){
        this.student = student;
    }

    public void exam() {
        System.out.println("考试的时候唱了一首凉凉，差点被劝退了。");
        student.exam();//调用Student类的方法
    }
}

public static void main(String[] args) {

    Exam xiaoMing = new Student();
    xiaoMing.exam();//原来的行为

    System.out.println("-----------下面是代理的行为------------");

    Exam cheater = new Cheater(xiaoMing);
    cheater.exam();//代理的行为

}

~~~
#### jdk代理
~~~
  /**
   * 动态代理类
  */
 public class DynamicProxy implements InvocationHandler {
     //被代理的对象
       Object targetObject;
     
     /**
      * 获得被代理后的对象
      * @param object 被代理的对象
      * @return 代理后的对象
      */
     public Object getProxyObject(Object object){
         this.targetObject=object;
         return Proxy.newProxyInstance(
                 targetObject.getClass().getClassLoader(), //类加载器
                 targetObject.getClass().getInterfaces(),  //获得被代理对象的所有接口
                 this);  //InvocationHandler对象
         //loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来生成代理对象进行加载
         //interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
         //h:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上，间接通过invoke来执行
     }
     
     
     /**
      * 当用户调用对象中的每个方法时都通过下面的方法执行，方法必须在接口
      * proxy 被代理后的对象
      * method 将要被执行的方法信息（反射）
      * args 执行方法时需要的参数
      */
     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
         
         //使用反射在目标对象上调用方法并传入参数
         Object result=method.invoke(targetObject, args);

         
         return result;
     } 
 }
~~~
#### cglib 代理
~~~
import java.lang.reflect.Method;
import java.util.Random;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/*
 * 动态代理类
 * 实现了一个方法拦截器接口
 */
public class DynamicProxy implements MethodInterceptor {

    // 被代理对象
    Object targetObject;

    //Generate a new class if necessary and uses the specified callbacks (if any) to create a new object instance. 
    //Uses the no-arg constructor of the superclass.
    //动态生成一个新的类，使用父类的无参构造方法创建一个指定了特定回调的代理实例
    public Object getProxyObject(Object object) {
        this.targetObject = object;
        //增强器，动态代码生成器
        Enhancer enhancer=new Enhancer();
        //回调方法
        enhancer.setCallback(this);
        //设置生成类的父类类型
        enhancer.setSuperclass(targetObject.getClass());
        //动态生成字节码并返回代理对象
        return enhancer.create();
    }

    // 拦截方法
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {

        // 调用方法
        Object result = methodProxy.invoke(targetObject, args);
        
        return result;
    }


}
~~~
