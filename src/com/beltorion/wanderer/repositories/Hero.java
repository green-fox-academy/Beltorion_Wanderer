package com.beltorion.wanderer.repositories;

import com.beltorion.wanderer.PositionedImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Hero extends JComponent implements java.awt.event.KeyListener {

    public static final String HERO_DOWN = "resources/img/hero-down.png";
    int testBoxX;
    int testBoxY;
    JLayeredPane layered = new JLayeredPane();


    public void setTestBoxY(int testBoxY) {
        this.testBoxY = testBoxY;
    }

    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
       // graphics.fillRect(testBoxX, testBoxY, 10, 10);
        PositionedImage heroDown = new PositionedImage(HERO_DOWN, testBoxX, testBoxY);
        heroDown.draw(graphics);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            testBoxY -= 72;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            testBoxY += 72;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            testBoxX -= 72;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            testBoxX += 72;
        }
        // és újra rajzolódik az új koordinátákkal
        repaint();

    }
}
