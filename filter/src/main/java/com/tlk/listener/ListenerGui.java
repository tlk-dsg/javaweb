package com.tlk.listener;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListenerGui {
    public static void main(String[] args){
        Frame frame =  new Frame("Hello tlk");//窗体
        Panel panel = new Panel(null);//面板
        frame.setLayout(null);

        frame.setBounds(100 , 100 , 500 , 500);
        frame.setBackground(new Color(255 , 0 , 255));

        panel.setBounds(0 , 0 , 700 , 700);
        panel.setBackground(new Color(0 , 255 , 0));

        frame.add(panel);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
