package com.datastruct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameMaze extends JPanel implements KeyListener {

    Player player = new Player();
    Score score = new Score();
    DataMaze data = new DataMaze();

    boolean gameOver = false;
    Timer timer;

    public GameMaze() {
        JFrame frame = new JFrame("Tree Maze Escape Game");
        frame.setSize(1530, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setVisible(true);

        timer = new Timer(1000, e -> {
            if (!gameOver) {
                score.waktuBerjalan();
                repaint();
            }
        });

        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLACK);

        g.setColor(Color.BLUE);
        for (Rectangle wall : data.walls) {
            g.fillRect(wall.x, wall.y, wall.width, wall.height);
        }

        g.setColor(Color.RED);
        g.fillOval(player.x, player.y, player.size, player.size);

        g.setColor(Color.YELLOW);
        for (Rectangle coin : data.coins) {
            g.fillOval(coin.x, coin.y, coin.width, coin.height);
        }

        g.setColor(new Color(150, 80, 220));
        for (Rectangle enemy : data.enemies) {
            g.fillOval(enemy.x, enemy.y, enemy.width, enemy.height);
        }

        g.setColor(Color.GREEN);
        g.fillRect(data.exit.x, data.exit.y, data.exit.width, data.exit.height);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + score.score, 20, 750);
        g.drawString("Time: " + score.time, 150, 750);
        g.drawString("Coin +10 | Enemy -5 | Waktu -1/detik", 260, 750);

        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 35));
            g.drawString("GAME SELESAI", 700, 320);
            g.setFont(new Font("Arial", Font.BOLD, 22));
            g.drawString("Score Akhir: " + score.score, 700, 350);
        }
    }

    void movePlayer(int dx, int dy) {
        if (gameOver) return;

        Rectangle next = new Rectangle(
                player.x + dx,
                player.y + dy,
                player.size,
                player.size
        );

        for (Rectangle wall : data.walls) {
            if (next.intersects(wall)) {
                return;
            }
        }

        player.x += dx;
        player.y += dy;

        Rectangle playerBox = player.getBounds();

        for (int i = 0; i < data.coins.size(); i++) {
            if (playerBox.intersects(data.coins.get(i))) {
                score.tambahCoin();
                data.coins.remove(i);
                break;
            }
        }

        for (Rectangle enemy : data.enemies) {
            if (playerBox.intersects(enemy)) {
                score.kenaEnemy();
                player.reset();
                break;
            }
        }

        if (playerBox.intersects(data.exit)) {
            gameOver = true;
            timer.stop();
        }

        repaint();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_UP) movePlayer(0, -10);
        if (key == KeyEvent.VK_DOWN) movePlayer(0, 10);
        if (key == KeyEvent.VK_LEFT) movePlayer(-10, 0);
        if (key == KeyEvent.VK_RIGHT) movePlayer(10, 0);
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}