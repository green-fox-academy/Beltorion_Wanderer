package com.beltorion.wanderer.repositories;

import javax.swing.*;
import java.awt.*;

public class Board  {

    JFrame frame = new JFrame();
    Tile tile = new Tile();
    Hero hero = new Hero();

    public Board(){
        frame.setTitle("Wanderer Game");
        frame.add(hero);
        frame.addKeyListener(hero);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(720,720);
        frame.setResizable(false);
        frame.setVisible(true);
       // frame.pack();
        ImageIcon image = new ImageIcon("resources/img/hero-down.png"); //create an ImageIcon
        frame.setIconImage(image.getImage()); //change icon of frame
        frame.add(tile);
    }
}
