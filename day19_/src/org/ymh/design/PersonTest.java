package org.ymh.design;

public class PersonTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(15);
        Person person1 = (Person) person.clone();
        System.out.println(person == person1);
        person.setAge(10);
        System.out.println(person.getAge());
        System.out.println(person1.getAge());

    }
}
