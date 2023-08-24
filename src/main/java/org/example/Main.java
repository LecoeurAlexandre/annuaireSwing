package org.example;

import org.example.view.MainFrame;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame jFrame = new JFrame("Menu");
                jFrame.setSize(350, 300);
                jFrame.setContentPane(new MainFrame().getMainPanel());
                jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                jFrame.setVisible(true);
            }
        });
    }
}