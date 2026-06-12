package com.datastruct;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MazeGame extends JPanel implements KeyListener {

    int playerX = 755, playerY = 320;
    int size = 25;

    int score = 0;
    int time = 0;
    boolean gameOver = false;

    ArrayList<Rectangle> walls = new ArrayList<>();
    ArrayList<Rectangle> coins = new ArrayList<>();
    ArrayList<Rectangle> enemies = new ArrayList<>();
    Rectangle exit = new Rectangle(19, 600, 40, 40);

    Timer timer;

    public MazeGame() {
        JFrame frame = new JFrame("Tree Maze Escape Game");
        frame.setSize(650, 620);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.addKeyListener(this);
        frame.setVisible(true);

        buatMaze();

        timer = new Timer(1000, e -> {
            if (!gameOver) {
                time++;
                score--;
                repaint();
            }
        });
        timer.start();
    }

    void buatMaze() {
        // dinding luar
        walls.add(new Rectangle(0, 0, 2000, 20));
        walls.add(new Rectangle(0, 640, 2000, 20));
        walls.add(new Rectangle(0, 0, 20, 660));
        walls.add(new Rectangle(1510, 0, 20, 660));

        // dinding dalam maze
       //walls.add(new Rectangle(755, 320 ,25,25));//kordinat player
       walls.add(new Rectangle(725, 350 ,25,200));//bawah 1
       walls.add(new Rectangle(785,410,25,195));//bawah 2
       walls.add(new Rectangle(120, 290 ,620,25));//samping kiri
       walls.add(new Rectangle(120, 350 ,620,25));//samping kiri
        walls.add(new Rectangle(785, 290 ,680,25));//samping kanan
        walls.add(new Rectangle(785, 350,620,25));//samping kanan
        walls.add(new Rectangle(725,60,25,255));//atas kiri
        walls.add(new Rectangle(785,60,25,230));//atas kanan
        walls.add(new Rectangle(60, 580 ,750,25));//samping kiri 3
        walls.add(new Rectangle(785, 60 ,680,25));//samping kanan bawah 1
        walls.add(new Rectangle(60, 60 ,670,25));//samping kiri 1
         walls.add(new Rectangle(850, 120 ,660,25));//samping kanan bawah 2

    
        walls.add(new Rectangle(0, 150 ,685,25));// 1 bag 1
        walls.add(new Rectangle(70, 220 ,610,25));// bag 1
        walls.add(new Rectangle(60,80,25,40));// bag 1
       walls.add(new Rectangle(110,120,25, 70));// bag 1
       walls.add(new Rectangle(120,280,25, 10));// bag 1
       walls.add(new Rectangle(210,280,25, 10));// bag 1
       walls.add(new Rectangle(310,280,25, 10));// bag 1
        walls.add(new Rectangle(410,280,25, 10));// bag 1
        walls.add(new Rectangle(510,280,25, 10));// bag 1
        walls.add(new Rectangle(610,280,25, 10));// bag 1
       walls.add(new Rectangle(160,210,25,40));// bag 1
       walls.add(new Rectangle(160,80,25,40));// bag 1
       walls.add(new Rectangle(210,120,25, 70));// bag 1
       walls.add(new Rectangle(260,210,25,50));// bag 1
       walls.add(new Rectangle(260,80,25,40));// bag 1
       walls.add(new Rectangle(360,210,25,50));// bag 1
       walls.add(new Rectangle(310,120,25, 70));// bag 1
       walls.add(new Rectangle(360,80,25,40));// bag 1
       walls.add(new Rectangle(410,120,25, 70));// bag 1
       walls.add(new Rectangle(460,210,25,50));// bag 1
       walls.add(new Rectangle(460,80,25,40));// bag 1
       walls.add(new Rectangle(560,210,25,50));// bag 1
       walls.add(new Rectangle(510,120,25, 70));// bag 1
       walls.add(new Rectangle(560,80,25,40));// bag 1
       walls.add(new Rectangle(610,120,25, 70));// bag 1
       walls.add(new Rectangle(660,80,25, 40));// bag 1
       

        walls.add(new Rectangle(850,180,25,120));//atas kanan 2 bag2
        walls.add(new Rectangle(910,140,25,120));//atas kanan 2 bag 2
        walls.add(new Rectangle(970,180,25,120));//atas kanan 2 bag 2
        walls.add(new Rectangle(1030,140,25,120));//atas kanan 2 bag 2
        walls.add(new Rectangle(1090,180,25,120));//atas kanan 2 bag 2
        walls.add(new Rectangle(1150,140,25,120));//atas kanan 2 bag 2
        walls.add(new Rectangle(1210,180,25,120));//atas kanan 2 bag 2
        walls.add(new Rectangle(1270,140,25,120));//atas kanan 2 bag 2
        walls.add(new Rectangle(1330,180,25,120));//atas kanan 2 bag 2
        walls.add(new Rectangle(1390,140,25,120));//atas kanan 2 bag 2
        walls.add(new Rectangle(1450,180,25,430));//atas kanan 2 bag 2

    walls.add(new Rectangle(70,240,25,310));// bag 3
       walls.add(new Rectangle(120,360,25,120));// bag 3
       walls.add(new Rectangle(80, 525 ,605,25));//bag 3
       walls.add(new Rectangle(180,420,25,120));// bag 3
       walls.add(new Rectangle(240,360,25,120));// bag 3
       walls.add(new Rectangle(300,420,25,120));// bag 3
       walls.add(new Rectangle(360,360,25,120));// bag 3
       walls.add(new Rectangle(420,420,25,120));// bag 3
       walls.add(new Rectangle(480,360,25,120));// bag 3
       walls.add(new Rectangle(540,420,25,120));// bag 3
       walls.add(new Rectangle(600,360,25,120));// bag 3
       walls.add(new Rectangle(660,420,25,120));// bag 3

        walls.add(new Rectangle(850, 410 ,600,25));
       walls.add(new Rectangle(800, 470 ,600,25));
       walls.add(new Rectangle(850,530 ,600,25));
        walls.add(new Rectangle(850, 590 ,560,25));//bag  4
       
       
      
        //x:755 /y:320 titik player
 
        // coin
            coins.add(new Rectangle(120, 90, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(210, 90, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(310, 90, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(410, 90, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(500, 90, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(600, 90, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(120, 245, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(210, 245, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(310, 245, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(410, 245, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(500, 245, 25, 25)); //koin bagian 1
            coins.add(new Rectangle(600, 245, 25, 25)); //koin bagian 1

            coins.add(new Rectangle(830, 90, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(890, 90, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(950, 90, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1010, 90, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1070, 90, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1130, 90, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1190, 90, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1250, 90, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1310, 90, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1370, 90, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(820, 265, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(910, 265, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1030, 265, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1150, 265, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1270, 265, 25, 25)); //koin bagian 2
            coins.add(new Rectangle(1390, 265, 25, 25)); //koin bagian 2
    
        coins.add(new Rectangle(600, 550, 25, 25));//koin bagian 3
         coins.add(new Rectangle(550, 550, 25, 25));//koin bagian 3
          coins.add(new Rectangle(500, 550, 25, 25));//koin bagian 3
           coins.add(new Rectangle(450, 550, 25, 25));//koin bagian 3
           coins.add(new Rectangle(590, 500, 25, 25)); //koin bagian 3
           coins.add(new Rectangle(470, 500, 25, 25)); //koin bagian 3
           coins.add(new Rectangle(370, 500, 25, 25));//koin bagian 3
           coins.add(new Rectangle(250, 500, 25, 25));//koin bagian 3
           coins.add(new Rectangle(120, 500, 25, 25));//koin bagian 3
            coins.add(new Rectangle(590, 500, 25, 25)); //koin bagian 3
           coins.add(new Rectangle(470, 610, 25, 25)); //koin bagian 3
           coins.add(new Rectangle(370, 610, 25, 25));//koin bagian 3
           coins.add(new Rectangle(250, 610, 25, 25));//koin bagian 3
           coins.add(new Rectangle(120, 610, 25, 25));//koin bagian 3

           coins.add(new Rectangle(910, 500, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1030, 500, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1150, 500, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1270, 500, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1390, 500, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(910, 440, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1030, 440, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1150, 440, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1270, 440, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1390, 440, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(910, 380, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1030, 380, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1150, 380, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1270, 380, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1390, 380, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(910, 560, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1030, 560, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1150, 560, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1270, 560, 25, 25)); //koin bagian 4
            coins.add(new Rectangle(1390, 560, 25, 25)); //koin bagian 4
        

        // enemy
        
        enemies.add(new Rectangle(660, 550, 30, 30)); //musuh bagian 3
        enemies.add(new Rectangle(820, 500, 30, 30)); //musuh bagian 4
        enemies.add(new Rectangle(850, 610, 30, 30)); //musuh bagian 4
    
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.BLACK);

        // maze wall
        g.setColor(Color.BLUE);
        for (Rectangle wall : walls) {
            g.fillRect(wall.x, wall.y, wall.width, wall.height);
        }

        // player
        g.setColor(Color.RED);
        g.fillOval(playerX, playerY, size, size);

        // coin
        g.setColor(Color.YELLOW);
        for (Rectangle coin : coins) {
            g.fillOval(coin.x, coin.y, coin.width, coin.height);
        }

        // enemy
        g.setColor(new Color(150, 80, 220));
        for (Rectangle enemy : enemies) {
            g.fillOval(enemy.x, enemy.y, enemy.width, enemy.height);
        }

        // exit
        g.setColor(Color.GREEN);
        g.fillRect(exit.x, exit.y, exit.width, exit.height);

        // text
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 18));
        g.drawString("Score: " + score, 20, 750);
        g.drawString("Time: " + time, 150, 750);
        g.drawString("Coin +10 | Enemy -5 | Waktu -1/detik", 260, 750);

        if (gameOver) {
            g.setFont(new Font("Arial", Font.BOLD, 35));
            g.drawString("GAME SELESAI", 700, 320);
            g.setFont(new Font("Arial", Font.BOLD, 22));
            g.drawString("Score Akhir: " + score, 700, 350);
        }
    }

    void movePlayer(int dx, int dy) {
        if (gameOver) return;

        Rectangle next = new Rectangle(playerX + dx, playerY + dy, size, size);

        for (Rectangle wall : walls) {
            if (next.intersects(wall)) {
                return;
            }
        }

        playerX += dx;
        playerY += dy;

        Rectangle player = new Rectangle(playerX, playerY, size, size);

        for (int i = 0; i < coins.size(); i++) {
            if (player.intersects(coins.get(i))) {
                score += 10;
                coins.remove(i);
                break;
            }
        }

        for (Rectangle enemy : enemies) {
            if (player.intersects(enemy)) {
                score -= 5;
                playerX = 755;
                playerY = 320;
                break;
            }
        }

        if (player.intersects(exit)) {
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

    public static void main(String[] args) {
       MazeGame maze = new MazeGame();
    }
}