package com.dk.learndemo.designpattern.command.cooking;

import javax.swing.*;

/**
 * @Description : HeFenChef
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class HeFenChef extends JFrame {

    private static final long serialVersionUID = 1L;
    JLabel l = new JLabel();

    HeFenChef() {
        super("煮河粉");
        //假装有图片
        l.setIcon(new ImageIcon("C:\\github\\learndemo\\src\\main\\resources\\templates\\images\\河粉.jpg"));
        this.add(l);
        this.setLocation(200, 280);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cooking() {
        this.setVisible(true);
    }
}
