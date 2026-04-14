package com.safro.snake;

public class Snake {

    public int direction = 1;
    public int lengthSnake = 2;

    public int snakeX[] = new int[SnakeGame.WIDTH * SnakeGame.HEIGHT];
    public int snakeY[] = new int[SnakeGame.WIDTH * SnakeGame.HEIGHT];

    public Snake(int x0, int y0, int x1, int y1) {
        snakeX[0] = x0;
        snakeY[0] = y0;
        snakeX[1] = x1;
        snakeY[1] = y1;
    }

    public void move() {
        for (int d = lengthSnake; d > 0; d--) {
            snakeX[d] = snakeX[d - 1];
            snakeY[d] = snakeY[d - 1];
        }

        if (direction == 0) snakeX[0]++;
        if (direction == 1) snakeY[0]++;
        if (direction == 2) snakeX[0]--;
        if (direction == 3) snakeY[0]--;

        for (int d = lengthSnake - 1; d > 0; d--) {
            if ((snakeX[0] == snakeX[d]) && (snakeY[0] == snakeY[d])) lengthSnake = d;
        }

        if (snakeX[0] > SnakeGame.WIDTH - 1) snakeX[0] = 0;
        if (snakeX[0] < 0) snakeX[0] = SnakeGame.WIDTH - 1;

        if (snakeY[0] > SnakeGame.HEIGHT - 1) snakeY[0] = 0;
        if (snakeY[0] < 0) snakeY[0] = SnakeGame.HEIGHT - 1;
    }
}
