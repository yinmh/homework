package org.ymh.design;
//单例模式--终极版
public class Singleton2 {
    private Singleton2(){

    }
    private  static  class inner{
        private static  final  Singleton2 ME = new Singleton2();
    }

    public static Singleton2 getInstance(){
        return inner.ME;
    }
}
