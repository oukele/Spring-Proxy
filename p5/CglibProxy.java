package com.oukele.p5;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    /*
    * 参数
    * Object 为由CGLib动态生成的代理类实例
    * method 为上文中实体类所调用的被代理的方法引用
    * objects 为参数值列表
    * methodProxy 为生成的代理类对方法的代理引用
    * return 从代理实例的方法调用返回的值
    * */
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("考试的时候，唱了一首 我爱洗澡 ，差点被劝退 ");
        return methodProxy.invokeSuper(o,objects);
    }

}
