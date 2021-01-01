package com.beltorion.wanderer.repositories;

import com.beltorion.wanderer.PositionedImage;

import javax.swing.*;
import java.awt.*;

public class TileOld extends JComponent {

    private static final String FLOOR_PNG = "resources/img/floor.png";
    private static final String Wall_PNG = "resources/img/wall.png";
    private TileType type;
    private int ImgPosX;
    private int ImgPosY;

    public TileOld() {
    }
    public TileOld(int ImgPosX, int ImgPosY, TileType type) {
        this.ImgPosX = ImgPosX;
        this.ImgPosY = ImgPosY;
        this.type = type;
    }

    public static String getFloorPng() {
        return FLOOR_PNG;
    }

    public static String getWall_PNG() {
        return Wall_PNG;
    }

    public TileType getType() {
        return type;
    }

    public void setType(TileType type) {
        this.type = type;
    }

    public int getImgPosX() {
        return ImgPosX;
    }

    public void setImgPosX(int imgPosX) {
        ImgPosX = imgPosX;
    }

    public int getImgPosY() {
        return ImgPosY;
    }

    public void setImgPosY(int imgPosY) {
        ImgPosY = imgPosY;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
        PositionedImage floor = new PositionedImage(FLOOR_PNG, ImgPosX, ImgPosY, TileType.floor);
        PositionedImage wall = new PositionedImage(Wall_PNG, ImgPosX, ImgPosY, TileType.wall);

//        wall.paintMap(graphics);
       floor.paintMap(graphics);
//        floor.DrawMap(graphics);
    }
}
