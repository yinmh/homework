package org.ymh.自学设计模式_工厂设计模式;
 class Test1 {
     public static void main(String[] args) {
         AbstractFactory abstractFactory = new JLFactory();
         King king = abstractFactory.createKing();
     }

}
