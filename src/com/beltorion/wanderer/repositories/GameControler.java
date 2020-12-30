package com.beltorion.wanderer.repositories;

public class GameControler implements Runnable {

    private Board board;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    public GameControler(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;

    }

    private void init() {
        board = new Board(title, width, height);

    }

    private void upDate() {

    }

    private void render() {

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
        if(!running)
            return;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
