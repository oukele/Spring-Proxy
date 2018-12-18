package com.oukele.p5;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {

        //增强器，动态代码生成器
        Enhancer enhancer = new Enhancer();
        //设置 生成类 的 父类
        enhancer.setSuperclass(Student.class);
        //回调函数
        enhancer.setCallback(new CglibProxy());
        //动态生成字节码并返回代理对象
        Student o = (Student) enhancer.create();
        o.exam();

        //这里是简化写法
        //第一个参数 设置 生成类 的父类 ，第二参数 被代理类的所有接口 ，回调函数
        Student student = (Student) new Enhancer().create(Student.class, null, new CglibProxy());
        student.exam();
    }
}
