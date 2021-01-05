package com.beltorion.wanderer;

import com.beltorion.wanderer.controllers.GameController;

public class Wanderer {

    public static void main(String[] args) {
        GameController gameController = new GameController("wanderer", 720, 720);
        gameController.start();
    }
}
