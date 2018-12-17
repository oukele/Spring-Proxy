package com.oukele.p2;

public class Cheater implements Exam {

    private final Exam student;

    public Cheater(Exam student){
        this.student = student;
    }

    public void exam() {
        System.out.println("考试的时候唱了一首凉凉，差点被劝退了。");
        student.exam();//调用Student类的方法
    }
}
