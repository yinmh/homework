package org.ymh.design;
/**
 * 饿汉式
 * */
public class Singleton {
   //构造方法私有
    private Singleton(){

    }
    //内部创建对象
    private final  static  Singleton ME = new Singleton();

    //外部获取该类对象的方法
    public static Singleton getInstance(){
        return ME;
    }
}
