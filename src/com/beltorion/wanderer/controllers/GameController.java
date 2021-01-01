package com.beltorion.wanderer.controllers;

import com.beltorion.wanderer.repositories.Board;
import com.beltorion.wanderer.repositories.GameMap;
import com.beltorion.wanderer.repositories.Hero;
import com.beltorion.wanderer.repositories.Tile;
import com.beltorion.wanderer.services.Images;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class GameController implements Runnable {

    private Board board;
    public int width, height;
    public String title;
    private GameMap map;

    private static final int imageSize = 72;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    Hero hero = new Hero(0, 0);
    Tile tile = new Tile(72, 72, null);

    public GameController(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init() {
        board = new Board(title, width, height);
        board.getFrame().addKeyListener(hero);
        map = new GameMap();

        Images.init();
    }

    private void upDate() {
    }

    private void render() {
        //Storing the data before displaying on the screen to make the display smoother
        bufferStrategy = board.getCanvas().getBufferStrategy();
        if (bufferStrategy == null) {
            board.getCanvas().createBufferStrategy(3);
            return;
        }
        graphics = bufferStrategy.getDrawGraphics();

        // Clear Screen
        graphics.clearRect(0, 0, width, height);

        // Draw here

        GameMap.drawMap(graphics);
        // tile.render(graphics);
        hero.render(graphics);

        //End drawing

        bufferStrategy.show();
        graphics.dispose();
    }


    /* Needs for Runnable interface
    starts the program, refresh the variables and renders the elements to the screen.
    At the end it is stopping the program if necessary

     */
    public void run() {
        init();
        // Optimizing the game running

        // How many time the update runs/second
        int fps = 60;
        // 1000000000 nanosecond = 1 sec. It sets the fps to one frame per second
        double timePerUpdate = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        // checking if it is correct
        //        long timer =0;
        //        long upDates=0;

        while (running) {
            now = System.nanoTime();

            //sets when to call the upDate method again.
            delta += (now - lastTime) / timePerUpdate;
            //timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                upDate();
                render();
                //  upDates++;
                delta--;
            }

//            if (timer >= 1000000000) {
//                System.out.println("Updates and Frames: " + upDates);
//                upDates=0;
//                timer=0;
//            }
        }
        stop();
    }

    //Starts the thread
    public synchronized void start() {
        if (running)
            return;
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    //Stops the thread
    public synchronized void stop() {
        if (!running)
            return;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
