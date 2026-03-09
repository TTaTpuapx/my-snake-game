package com.safro.snake;

public class Apple {
    private int posX;
    private int posY;

    public Apple() {
        setRandomPosition();
    }

    public void setRandomPosition() {
        posX = (int) (Math.random() * SnakeGame.WIDTH);
        posY = (int) (Math.random() * SnakeGame.HEIGHT);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }
}