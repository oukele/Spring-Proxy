### 代理 proxy
 ~~~
    //cheater 就是一个代理对象
    //因为它是受student 委托 完成某些功能
    //它要完成的主要功能，来自student
    //除了委托的事情，可能还会拓展一些行为
    Student student = new Student();
    Cheater cheater = new Cheater(student);
    cheater.exam();
    
    -----------------------------------------------------
    
    Examable e = new Student();
    e.exam();//原来的行为
    System.out.println("-----------------------代理的行为-----------------------");
    Examable cheater = new Cheater(e);
    cheater.exam();//代理的行为
    
    运行结果：
    
    完成考试了。。。
    -----------------------代理的行为-----------------------
    唱了一首歌，差点被劝退
    完成考试了。。。
    但是忘记写了名字
    
    
    
 ~~~
