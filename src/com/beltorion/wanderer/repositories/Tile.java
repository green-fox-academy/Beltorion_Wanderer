package com.beltorion.wanderer.repositories;

import com.beltorion.wanderer.PositionedImage;

import javax.swing.*;
import java.awt.*;

public class Tile extends JComponent {

    public static final String FLOOR_PNG = "resources/img/floor.png";
    int floorImgPosX;
    int floorImgPosY;

    public Tile() {
    }

    public Tile(int floorImgPosX, int floorImgPosY) {
        this.floorImgPosX = floorImgPosX;
        this.floorImgPosY = floorImgPosY;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        PositionedImage floor = new PositionedImage(FLOOR_PNG, floorImgPosX, floorImgPosY);
        floor.paintMap(graphics);
    }
}
