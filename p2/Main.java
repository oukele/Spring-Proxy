package com.oukele.p2;

public class Main {

    public static void main(String[] args) {
//        Student student = new Student();
//        student.Exam();

//        Cheater cheater = new Cheater();
//        cheater.exam();


        Exam xiaoMing = new Student();
        xiaoMing.exam();//原来的行为
        System.out.println("-----------下面是代理的行为------------");
        Exam cheater = new Cheater(xiaoMing);
        cheater.exam();//代理的行为



    }

}
