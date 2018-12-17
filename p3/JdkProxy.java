package com.oukele.p3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkProxy implements InvocationHandler {

    private final  Object object;//被代理的对象

    public JdkProxy(Object object){//初始化的时候就赋值
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("考试的时候，吃颗糖压压惊，没有人知道，这次不是本人来考试的");
        //System.out.println("原来的方法 --> "+method.getName());
        //方法名 时间  打印异常处理
        return method.invoke(object,args);//调用被代理对象原来的方法(行为)
    }
}
