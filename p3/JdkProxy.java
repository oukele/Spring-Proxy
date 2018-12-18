package com.oukele.p3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxy implements InvocationHandler {

    private Object object;//被代理的对象

    public JdkProxy() {
    }

    public JdkProxy(Object object) {//初始化的时候就赋值
        this.object = object;
    }

    public Object getObject(Object object) {
        this.object = object;//代理对象
        return Proxy.newProxyInstance(
                object.getClass().getClassLoader(),//被代理对象的类加载器
                object.getClass().getInterfaces(),//获取被代理对象的所有接口
                this//InvocationHandler对象
        );
    }


    /**
     * 当用户调用对象中的每个方法时都通过下面的方法执行，方法必须在接口
     * proxy 被代理后的对象
     * method 将要被执行的方法信息（反射）
     * args 执行方法时需要的参数
     */
    public Object invoke(Object proxy, Method method, Object[] args) {
        System.out.println("考试的时候，吃颗糖压压惊，没有人知道，这次不是本人来考试的");

        //方法名 时间  打印异常处理
        System.out.println("方法名 --> " + method.getName());
        System.out.println(this.object.getClass().getSimpleName());
        // 1 秒 = 1000 毫秒
        // 1分 = 60秒
        // 1 分 = 60 * 1000
        long start = (System.currentTimeMillis()) / 1000;
        System.out.println("开始时间：" + start);
        Object invoke = null;
        try {
            invoke = method.invoke(object, args);
        } catch (Exception x) {
            System.out.println("异常信息：" + x.getMessage());
        }

        //Thread.sleep(4000);

        System.out.println("结束时间：" + ((System.currentTimeMillis()) / 1000 - start));

        return invoke;//调用被代理对象原来的方法(行为)
    }
}
