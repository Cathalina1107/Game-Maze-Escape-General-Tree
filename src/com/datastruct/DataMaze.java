package com.datastruct;

import java.awt.Rectangle;
import java.util.ArrayList;

public class DataMaze {
    ArrayList<Rectangle> walls = new ArrayList<>();
    ArrayList<Rectangle> coins = new ArrayList<>();
    ArrayList<Rectangle> enemies = new ArrayList<>();
    Rectangle exit = new Rectangle(19, 600, 40, 40);

    public DataMaze() {
        buatMaze();
    }

    void buatMaze() {
        walls.add(new Rectangle(0, 0, 2000, 20));
        walls.add(new Rectangle(0, 640, 2000, 20));
        walls.add(new Rectangle(0, 0, 20, 660));
        walls.add(new Rectangle(1510, 0, 20, 660));

        walls.add(new Rectangle(725, 350, 25, 200));
        walls.add(new Rectangle(785, 410, 25, 195));
        walls.add(new Rectangle(120, 290, 620, 25));
        walls.add(new Rectangle(120, 350, 620, 25));
        walls.add(new Rectangle(785, 290, 680, 25));
        walls.add(new Rectangle(785, 350, 620, 25));
        walls.add(new Rectangle(725, 60, 25, 255));
        walls.add(new Rectangle(785, 60, 25, 230));

        coins.add(new Rectangle(120, 90, 25, 25));
        coins.add(new Rectangle(210, 90, 25, 25));
        coins.add(new Rectangle(310, 90, 25, 25));
        coins.add(new Rectangle(410, 90, 25, 25));
        coins.add(new Rectangle(500, 90, 25, 25));
        coins.add(new Rectangle(600, 90, 25, 25));

        enemies.add(new Rectangle(660, 550, 30, 30));
        enemies.add(new Rectangle(820, 500, 30, 30));
        enemies.add(new Rectangle(850, 610, 30, 30));
    }
}