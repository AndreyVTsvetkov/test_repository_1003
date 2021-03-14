package ru.sber.calculate;

import java.awt.*;
import javax.swing.*;

public class Application {
    public static void main(String[] args) {
        //вызываем визуальную форму кальулятора
        EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                CalculatorFrame frame = new CalculatorFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }
}
