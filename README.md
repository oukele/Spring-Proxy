### 代理 proxy
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
         //被织入的内容，开始时间
         long start=System.currentTimeMillis();
         lazy();
         
         //使用反射在目标对象上调用方法并传入参数
         Object result=method.invoke(targetObject, args);
         
         //被织入的内容，结束时间
         Long span= System.currentTimeMillis()-start;
         System.out.println("共用时："+span);
         
         return result;
     }
 
 ~~~
