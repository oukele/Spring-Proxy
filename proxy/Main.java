package com.oukele.proxy;

public class Main {
    public static void main(String[] args) {

        Examable e = new Student();
        e.exam();//原来的行为
        System.out.println("-----------------------代理的行为-----------------------");
        Examable cheater = new Cheater(e);
        cheater.exam();//代理的行为


    }
}
