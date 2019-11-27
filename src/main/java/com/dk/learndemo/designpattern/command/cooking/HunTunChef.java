package com.dk.learndemo.designpattern.command.cooking;

import javax.swing.*;

/**
 * @Description : HunTunChef
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class HunTunChef extends JFrame {
    private static final long serialVersionUID = 1L;
    JLabel l = new JLabel();

    HunTunChef() {
        super("煮馄饨");
        //假装有图片
        l.setIcon(new ImageIcon("C:\\github\\learndemo\\src\\main\\resources\\templates\\images\\馄饨.jpg"));
        this.add(l);
        this.setLocation(350, 50);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cooking() {
        this.setVisible(true);
    }
}
