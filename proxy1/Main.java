package com.oukele.proxy1;

import com.oukele.p1.jdkSingProxy;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {
//        Sleepable girl =  new Girl();
//        girl.sleep();
//        Sleepable grilProxy = new GrilProxy(girl);
//        grilProxy.sleep();



        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Sleepable o = (Sleepable) Proxy.newProxyInstance(
                cl,//类加载器
                Girl.class.getInterfaces(),//获得被代理对象的所有接口
                new jdkSingProxy(new Girl())//InvocationHandler对象
        );
        o.sleep();

        Sleepable o1 = (Sleepable) Proxy.newProxyInstance(
                cl,
                new Class[]{Sleepable.class},
                new jdkSingProxy(new Girl())
        );
        o1.sleep();

    }
}
