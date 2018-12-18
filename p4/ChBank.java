package com.oukele.p4;

public class ChBank {

    public void take (float money){

        if( money > 30000){
            System.out.println("余额不足");
        }else if( money < 0){
            System.out.println("取款要大于零");
        }else {
            System.out.println("取多少钱:"+money);
        }



    }


}
