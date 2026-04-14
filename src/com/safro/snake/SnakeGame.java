package com.safro.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame extends JPanel implements ActionListener {

    public static final int SCALE = 32;
    public static final int WIDTH = 20;
    public static final int HEIGHT = 20;
    public static final int SPEED = 5;

    Apple apple = new Apple();
    Snake snake = new Snake(10, 10, 9, 10);
    Timer timer = new Timer(1000 / SPEED, this);

    public SnakeGame() {
        timer.start();
        addKeyListener(new Listeners());
        setFocusable(true);
    }

    public void paint(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, WIDTH * SCALE, HEIGHT * SCALE);

        g.setColor(Color.white);
        for (int xx = 0; xx <= WIDTH * SCALE; xx += SCALE) {
            g.drawLine(xx, 0, xx, HEIGHT * SCALE);
        }
        for (int yy = 0; yy <= HEIGHT * SCALE; yy += SCALE) {
            g.drawLine(0, yy, WIDTH * SCALE, yy);
        }
        for (int d = 0; d < snake.lengthSnake; d++) {
            g.setColor(Color.GREEN);
            g.fillRect(snake.snakeX[d] * SCALE + 1, snake.snakeY[d] * SCALE + 1, SCALE - 1, SCALE - 1);
        }

        g.setColor(Color.red);
        g.fillRect(apple.getPosX() * SCALE + 1, apple.getPosY() * SCALE + 1, SCALE - 1, SCALE - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WIDTH * SCALE + 7, HEIGHT * SCALE + 4);
        frame.setLocationRelativeTo(null);
        frame.add(new SnakeGame());
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        snake.move();
        if ((snake.snakeY[0] == apple.getPosY()) && (snake.snakeX[0] == apple.getPosX())) {
            snake.lengthSnake++;
            apple.setRandomPosition();

            boolean flag = true;
            while (flag) {
                for (int i = 1; i <= snake.lengthSnake; i++) {
                    if ((snake.snakeX[0] == apple.getPosX() && (snake.snakeY[0] == apple.getPosY()))) {
                        apple.setRandomPosition();
                    } else {
                        flag = false;
                    }
                }
            }
        }
        repaint();
    }

    private class Listeners extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            int key = event.getKeyCode();

            if ((key == KeyEvent.VK_D) && (snake.direction != 2)) {
                snake.direction = 0;
            }
            if (key == KeyEvent.VK_S && (snake.direction != 3)) {
                snake.direction = 1;
            }
            if (key == KeyEvent.VK_A && (snake.direction != 0)) {
                snake.direction = 2;
            }
            if (key == KeyEvent.VK_W && (snake.direction != 1)) {
                snake.direction = 3;
            }
        }
    }
}
