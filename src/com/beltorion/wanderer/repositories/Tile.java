package com.beltorion.wanderer.repositories;

import com.beltorion.wanderer.services.Images;

import java.awt.*;

public class Tile {
    private TileType type;
    private int imgPosX;
    private int imgPosY;
    Images images = new Images();

    public Tile() {
    }

    public Tile(int ImgPosX, int ImgPosY, TileType type) {
        this.imgPosX = ImgPosX;
        this.imgPosY = ImgPosY;
        this.type = type;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(Images.floor, imgPosX, imgPosY,null);
    }
}
