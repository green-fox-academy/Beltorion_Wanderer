package com.beltorion.wanderer.repositories;

import com.beltorion.wanderer.controllers.Characters;
import com.beltorion.wanderer.services.Images;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Hero extends Characters implements java.awt.event.KeyListener {

    public Hero(float x, float y) {
        super(x, y);
    }

    @Override
    public void upDate() {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(Images.heroDown, (int) x, (int) y, null);
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            y -= 72;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            y += 72;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            x -= 72;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
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
}


