package com.beltorion.wanderer.repositories;

import com.beltorion.wanderer.ImageLoader;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class GameControler implements Runnable {

    private Board board;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bufferStrategy;
    private Graphics graphics;

    private BufferedImage testImage;
    private SpriteSheet sheet;

    Hero hero = new Hero();

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

        graphics.drawImage(sheet.crop(0,72,72,72), 0,0,null);
       // graphics.drawImage(testImage,0,0,null);
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
        while (running) {
            upDate();
            render();
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
