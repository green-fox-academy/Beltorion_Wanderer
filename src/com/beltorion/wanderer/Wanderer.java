package com.beltorion.wanderer;

import com.beltorion.wanderer.controllers.GameControler;

public class Wanderer {

    public static void main(String[] args) {
        GameControler gameControler = new GameControler("wanderer", 720, 720);
        gameControler.start();

//        GameMap gameMap=new GameMap();
//        gameMap.mapLenght();
    }
}
