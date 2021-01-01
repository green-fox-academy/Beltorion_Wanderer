package com.beltorion.wanderer.repositories;

import java.awt.*;

import static com.beltorion.wanderer.services.Images.*;
import com.beltorion.wanderer.repositories.Tile;


public class GameMap {

   //private static Tile tile;

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
                    //tile.floor(graphics);
                    graphics.drawImage(floor, j * 72, i * 72, null);
                } else graphics.drawImage(wall, j * 72, i * 72, null);
            }
        }
    }
}
