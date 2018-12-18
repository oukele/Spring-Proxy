package com.oukele.p4;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

     Object targetObject;

    public Object getTargetObject(Object targetObject) {
        this.targetObject = targetObject;
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(targetObject.getClass());
//        enhancer.setCallback(this);
//        return enhancer.create();
        return Enhancer.create(targetObject.getClass(),null,this);
    }

    //参数：Object为由CGLib动态生成的代理类实例，Method为上文中实体类所调用的被代理的方法引用，
    // Object[]为参数值列表，MethodProxy为生成的代理类对方法的代理引用。
    // 返回：从代理实例的方法调用返回的值
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("将整个操作记录到数据库");
        System.out.println("被代理对象:" + targetObject.getClass().getSimpleName());
        System.out.println("代理的行为：" + method.getName());
        return methodProxy.invoke(targetObject,objects);
        //return methodProxy.invokeSuper(targetObject, objects);
    }
}
