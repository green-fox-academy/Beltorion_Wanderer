package com.beltorion.wanderer.controllers;

import java.awt.*;

public abstract class Characters {

    public static final int DEFAULT_HP = 10;
    public static final int DEFAULT_DP = 10;
    public static final int DEFAULT_SP = 10;
    public static final int DEFAULT_SPEED = 72;

    protected float x, y;
    protected int hp;
    protected int dp;
    protected int sp;
    protected float speed;
    protected float xMove, yMove;


    public Characters(float x, float y) {
        this.x = x;
        this.y = y;
        hp = DEFAULT_HP;
        dp = DEFAULT_DP;
        sp = DEFAULT_SP;
        speed = DEFAULT_SPEED;
        xMove = 72;
        yMove = 72;
    }

    public abstract void upDate();

    public abstract void render(Graphics graphics);

    public void move() {
        x += xMove;
        y += yMove;
    }

    //GETTERS & SETTERS

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
