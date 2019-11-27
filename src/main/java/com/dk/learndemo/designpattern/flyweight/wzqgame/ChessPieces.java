package com.dk.learndemo.designpattern.flyweight.wzqgame;

import java.awt.*;

/**
 * @Description : ChessPieces
 * 抽象享元角色：棋子
 * @Date : 2019/11/26
 * @Author : zhudakang
 */
public interface ChessPieces {
    /**
     * 下棋子
     * */
    public void DownPieces(Graphics g, Point pt);
}
