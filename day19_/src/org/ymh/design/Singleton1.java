package org.ymh.design;
/**
 * 懒汉式
 * */
public class Singleton1 {
   //构造方法私有
    private Singleton1(){

    }
    //创建对象，不实例化
    private static Singleton1 ME = null;

    //外部获取该类对象的方法(线程安全的)
    public synchronized static Singleton1 getInstance(){
        if (ME == null){
            ME = new Singleton1();
        }
        return ME;
    }
}
