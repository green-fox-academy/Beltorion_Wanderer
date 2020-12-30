package com.beltorion.wanderer.repositories;

public class GameControler {
    private Board board;

    public int width, height;

    public GameControler(String title, int width, int height) {
        this.width = width;
        this.height = height;
        
        board = new Board(title, width, height);
    }
}
