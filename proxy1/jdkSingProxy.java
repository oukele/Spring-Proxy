package com.oukele.proxy1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class jdkSingProxy implements InvocationHandler {

    private final Object yuanlai;

    public jdkSingProxy(Object o){
        this.yuanlai = o;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("哦啦啦啦...................");
        //调用 yuanlai
        return method.invoke(yuanlai,args);
    }

}
