package com.oukele.p4;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
//        Enhancer enhancer = new Enhancer();
//        enhancer.setClassLoader(Thread.currentThread().getContextClassLoader());
//        enhancer.setSuperclass(ChBank.class);
//        enhancer.setCallback(new CglibProxy());

//        ChBank chBank = (ChBank) enhancer.create();
//        chBank.take(306660);
//
//        ChBank o = (ChBank) Enhancer.create(ChBank.class, null, new CglibProxy());
//        o.take(300);

        ChBank targetObject = (ChBank) new CglibProxy().getTargetObject(new ChBank());

        targetObject.take(30000);

    }
}
