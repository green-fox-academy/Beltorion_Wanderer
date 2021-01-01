package com.beltorion.wanderer.repositories;

import com.beltorion.wanderer.controllers.Characters;
import com.beltorion.wanderer.services.Images;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Hero extends Characters implements java.awt.event.KeyListener {

    private static boolean heroUpDown = true;
    String direction;

    public Hero(float x, float y) {
        super(x, y);
    }

    @Override
    public void upDate() {

    }

    @Override
    public void render(Graphics graphics) {
      //  graphics.drawImage(Images.heroDown, (int) x, (int) y, null);
        if (direction == "right") {
            graphics.drawImage(Images.heroRight, (int) x, (int) y, null);
        } else if (direction == "up") {
            graphics.drawImage(Images.heroUp, (int) x, (int) y, null);
        } else if(direction == "left") {
            graphics.drawImage(Images.heroLeft, (int) x, (int) y, null);
        } else graphics.drawImage(Images.heroDown, (int) x, (int) y, null);
    }


    @Override
    public void move() {
        super.move();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            direction ="down";
            y += 72;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            direction ="up";
            y -= 72;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            direction ="left";
            x -= 72;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            direction ="right";
            x += 72;
        }
        // és újra rajzolódik az új koordinátákkal
        //repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //empty block
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //empty block
    }

    public static boolean isHeroUpDown() {
        return heroUpDown;
    }

    public static void setHeroUpDown(boolean heroUpDown) {
        Hero.heroUpDown = heroUpDown;
    }
}



