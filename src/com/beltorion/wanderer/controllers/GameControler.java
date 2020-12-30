package com.beltorion.wanderer.controllers;

import com.beltorion.wanderer.repositories.Board;
import com.beltorion.wanderer.repositories.HeroOld;
import com.beltorion.wanderer.services.ImageLoader;
import com.beltorion.wanderer.services.Images;
import com.beltorion.wanderer.services.SpriteSheet;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameControler implements Runnable {

    private Board board;
    public int width, height;
    public String title;

    private static final int imageSize = 72;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    private BufferedImage testImage;
    private SpriteSheet sheet;

    HeroOld heroOld = new HeroOld();

    public GameControler(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
    }

    private void init() {
        board = new Board(title, width, height);
        testImage = ImageLoader.loadImage("/img/wandererSpriteSheet.png");
        //testImage = ImageLoader.loadImage("/img/hero-down.png");

        sheet = new SpriteSheet(testImage);
        Images.init();

    }

    int x = 0;

    private void upDate() {
        x += 1;
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

        graphics.drawImage(Images.floor, x, 72, null);
//        graphics.drawImage(Images.wall, imageSize,0, null);
//        graphics.drawImage(Images.boss, imageSize*2,0, null);
//        graphics.drawImage(Images.skeleton, imageSize*3,0, null);
//        graphics.drawImage(Images.heroDown, imageSize*4,0, null);
//        graphics.drawImage(Images.heroLeft, imageSize*5,0, null);
//        graphics.drawImage(Images.heroRight, imageSize*6,0, null);
//        graphics.drawImage(Images.heroUp, imageSize*7,0, null);

//        graphics.drawImage(Images.floor, 0,0, null);
//            int x = 0;
//            int y = 0;
//            for (int k = 0; k < 10; k++) {
//                for (int i = 0; i < 10; i++) {
//                    graphics.drawImage(testImage, x, y, null);
//                    x += 72;
//                }
//                x = 0;
//                y += 72;
//            }

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
        double timePerUpdate = 1000000000/fps;
        double delta =0;
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
