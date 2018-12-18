package com.oukele.proxy1;

public class GrilProxy implements Sleepable {

    private final Sleepable girl;

    public GrilProxy(Sleepable girl){
        this.girl = girl;
    }

    public void sleep() {
        System.out.println("先唱一首歌。。。。。。。");
        girl.sleep();
    }
}
