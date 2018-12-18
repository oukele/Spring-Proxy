package com.oukele.proxy;

public class Cheater implements Examable {

    private final Examable student;

    public Cheater(Examable student){
        this.student = student;
    }


    public void exam() {
        System.out.println("唱了一首歌，差点被劝退");
        student.exam();
        System.out.println("但是忘记写了名字");
    }
}
