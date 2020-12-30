package com.beltorion.wanderer.controllers;

import java.awt.*;

public abstract class Character {

    protected float x, y;
    protected int hp;
    protected int dp;
    protected int sp;


    public Character(float x, float y) {
        this.x = x;
        this.y = y;
        hp = 10;
        dp = 10;
        sp = 10;
    }

    public abstract void upDate();

    public abstract void render(Graphics graphics);
}
