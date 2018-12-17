package com.oukele.proxy;

public class Student implements Examable {

    public void playGame(){
        System.out.println("我玩得很开心");
    }

    public void exam() {
        System.out.println("完成考试了。。。");
    }
}
