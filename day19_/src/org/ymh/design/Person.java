package org.ymh.design;

import java.io.*;

public class Person implements Cloneable , Serializable {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(bo);
            objectOutputStream.writeObject(this);
            byte[] bytes = bo.toByteArray();
            ByteArrayInputStream bs = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(bs);
            Object object = objectInputStream.readObject();
            return object;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
