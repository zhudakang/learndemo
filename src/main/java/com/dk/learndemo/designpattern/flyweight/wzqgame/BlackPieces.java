package com.dk.learndemo.designpattern.flyweight.wzqgame;

import java.awt.*;

/**
 * @Description : BlackPieces
 * 黑子
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
public class BlackPieces implements ChessPieces {

    @Override
    public void DownPieces(Graphics g, Point pt) {
        g.setColor(Color.BLACK);
        g.fillOval(pt.x, pt.y, 30, 30);
    }
}
