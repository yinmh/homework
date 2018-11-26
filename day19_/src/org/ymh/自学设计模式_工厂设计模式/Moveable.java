package org.ymh.自学设计模式_工厂设计模式;
/**
 * 工厂模式主要是为创建对象提供过渡接口，以便将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的。
 * */

//抽象产品
interface Moveable {
    void run();
}
//具体产品1
class Plane implements Moveable {

    @Override
    public void run() {
        System.out.println("plane");
    }
}
//具体产品2
class Broom  implements Moveable {

    @Override
    public void run() {
        System.out.println("broom");
    }
}
//抽象工厂
abstract class VehicleFactory {
    abstract Moveable create();
}
//具体工厂
 class PlaneFactory extends VehicleFactory{
    public Moveable create() {
        return new Plane();
    }
}
//具体工厂2
class BroomFactory extends VehicleFactory{
    public Moveable create() {
        return new Broom();
    }
}
//测试类
class Test {
    public static void main(String[] args) {
        VehicleFactory factory = new BroomFactory();
        Moveable m = factory.create();
        m.run();
    }
}