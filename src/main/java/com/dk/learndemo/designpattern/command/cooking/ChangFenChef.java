package com.dk.learndemo.designpattern.command.cooking;

import javax.swing.*;

/**
 * @Description : ChangFenChef
 * @Date : 2019/11/27
 * @Author : zhudakang
 */
public class ChangFenChef extends JFrame {

    private static final long serialVersionUID = 1L;
    JLabel l = new JLabel();

    ChangFenChef() {
        super("煮肠粉");
        //假装有图片 假装给你一盒肠粉
        l.setIcon(new ImageIcon("C:\\github\\learndemo\\src\\main\\resources\\templates\\images\\肠粉.jpg"));
        this.add(l);
        this.setLocation(30, 30);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cooking() {
        this.setVisible(true);
    }
}
