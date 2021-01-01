package com.beltorion.wanderer;

import com.beltorion.wanderer.repositories.TileType;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PositionedImage {

    BufferedImage image;
    int posX, posY;
    TileType type;

    public PositionedImage(String filename, int posX, int posY, TileType type) {
        this.posX = posX;
        this.posY = posY;
        this.type = type;
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PositionedImage(String filename, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        try {
            image = ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics graphics) {
        if (image != null) {
            graphics.drawImage(image, posX, posY, null);
        }
    }

    public void paintMap(Graphics g) {
        int x = 0;
        int y = 0;
        for (int k = 0; k < 10; k++) {
            for (int i = 0; i < 10; i++) {
                g.drawImage(image, x, y, null);
                x += 72;
            }
            x = 0;
            y += 72;
        }
    }

}
