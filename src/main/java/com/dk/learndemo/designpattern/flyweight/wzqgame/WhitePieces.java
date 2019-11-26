package com.dk.learndemo.designpattern.flyweight.wzqgame;

import java.awt.*;

/**
 * @Description : WhitePieces
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
public class WhitePieces implements ChessPieces {
    @Override
    public void DownPieces(Graphics g, Point pt) {
        g.setColor(Color.WHITE);
        g.fillOval(pt.x, pt.y, 30, 30);
    }
}
