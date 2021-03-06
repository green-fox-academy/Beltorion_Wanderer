package com.beltorion.wanderer.repositories;

import java.awt.*;

import static com.beltorion.wanderer.services.Images.floor;
import static com.beltorion.wanderer.services.Images.wall;


public class GameMap {
    private static Tile tile = new Tile();
    //private static Tile tile;

//TODO Outsource to a file or new class

    public static int[][] mapArray = {
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 1, 0, 1, 0, 1, 1, 0,},
            {0, 1, 1, 1, 0, 1, 0, 1, 1, 0,},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0,},
            {1, 1, 1, 1, 0, 1, 1, 1, 1, 0,},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0,},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 1, 1, 0, 1, 0,},
            {0, 1, 1, 1, 0, 1, 1, 0, 1, 0,},
            {0, 0, 0, 1, 0, 0, 0, 0, 1, 0,},
    };

    public static void drawMap(Graphics graphics) {
        for (int i = 0; i < mapArray.length; i++) {
            for (int j = 0; j < mapArray[i].length; j++) {
                if (mapArray[i][j] == 0) {
                    tile.render(graphics, floor, j * 72, i * 72, TileType.FLOOR);
                } else tile.render(graphics, wall, j * 72, i * 72, TileType.WALL);
            }
        }
    }
}
