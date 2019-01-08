import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        Test a = new Test();
        Test a1 = new Test();
        System.out.println(a1 == a);
        System.out.println(a1.equals(a));


    }
}

