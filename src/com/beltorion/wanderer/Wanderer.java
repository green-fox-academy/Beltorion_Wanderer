package com.beltorion.wanderer;

import com.beltorion.wanderer.repositories.Board;
import com.beltorion.wanderer.repositories.Hero;

import javax.swing.*;

public class Wanderer {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Wanderer Game");

        Board board = new Board();
        Hero hero = new Hero();
        frame.add(board);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.pack();
        frame.add(hero);
        frame.addKeyListener(hero);

    }
}
