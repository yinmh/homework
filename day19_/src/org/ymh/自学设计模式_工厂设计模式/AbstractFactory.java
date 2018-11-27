package org.ymh.自学设计模式_工厂设计模式;
//抽象产品
interface Castle{
    abstract void castle();
}
interface King{
    abstract void king();
}
interface Army{
    abstract void army();
}
//产品实现类
class JLCastle implements Castle{

    @Override
    public void castle() {
        System.out.println("精灵国城堡");
    }
}

class JLKing implements King{

    @Override
    public void king() {
        System.out.println("精灵国国王");
    }
}
class SRKing implements King{

    @Override
    public void king() {
        System.out.println("兽人国国王");
    }
}
class SRCastle implements Castle{
    @Override
    public void castle() {
        System.out.println("兽人国城堡");
    }
}
class JLArmy implements Army{

    @Override
    public void army() {
        System.out.println("精灵国军队");
    }
}
class SRArmy implements Army{

    @Override
    public void army() {
        System.out.println("兽人国军队");
    }
}

//抽象王国
public interface AbstractFactory {
    Castle createCastle();
    King createKing();
    Army createArmy();
}
//王国实现
class JLFactory implements  AbstractFactory{

    @Override
    public Castle createCastle() {
        return new JLCastle();
    }

    @Override
    public King createKing() {
        return new JLKing();
    }

    @Override
    public Army createArmy() {
        return new JLArmy();
    }
}
class SRFactory implements  AbstractFactory{

    @Override
    public Castle createCastle() {
        return new SRCastle();
    }

    @Override
    public King createKing() {
        return new SRKing();
    }

    @Override
    public Army createArmy() {
        return new SRArmy();
    }
}

