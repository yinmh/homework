package org.ymh.design;

public class BuilderTest {
    public static void main(String[] args) {
        User user = new User.UserBuilder().password("sss").username("ssss").build();
    }
}
