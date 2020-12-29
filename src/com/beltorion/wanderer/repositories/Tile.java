package com.beltorion.wanderer.repositories;

import com.beltorion.wanderer.PositionedImage;

import javax.swing.*;
import java.awt.*;

public class Tile extends JComponent {

    public static final String FLOOR_PNG = "resources/img/floor.png";
    int floorImgPosX;
    int floorImgPosY;

    public Tile(int floorImgPosX, int floorImgPosY) {
        this.floorImgPosX = 0;
        this.floorImgPosY = 0;
    }


    public Tile() {

    }

    @Override
    public void paint(Graphics graphics) {
        PositionedImage floor = new PositionedImage(FLOOR_PNG, floorImgPosX, floorImgPosY);
        floor.draw(graphics);

    }
}
