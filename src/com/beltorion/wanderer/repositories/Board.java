package com.beltorion.wanderer.repositories;

import com.beltorion.wanderer.PositionedImage;

import javax.swing.*;
import java.awt.*;

public class Board extends JComponent {

    public static final String FLOOR_PNG = "resources/img/floor.png";

    public Board(int floorImgPosX, int floorImgPosY) {
        this.floorImgPosX = 0;
        this.floorImgPosY = 0;
    }

    int floorImgPosX;
    int floorImgPosY;

    public Board() {
        // beállítja a rajztábla méretét
        setPreferredSize(new Dimension(720, 720));
        setVisible(true);
    }

    @Override
    public void paint(Graphics graphics) {
        PositionedImage floor = new PositionedImage(FLOOR_PNG, floorImgPosX, floorImgPosY);
        floor.draw(graphics);

//        for (int i = 0; i < 9; i++) {
//            floorImgPosX = floorImgPosX + 72;
//        }
    }
}
