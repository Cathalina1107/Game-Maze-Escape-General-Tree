package com.datastruct;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        MazeGame maze = new MazeGame();

        ArrayList<TreeNode> path = TreeManage.cariJalanTercepat(
                maze.playerX,
                maze.playerY,
                maze.size,
                maze.walls,
                maze.enemies,
                maze.exit
        );

        TreeManage.tampilkanTreeJalur(path);
    }
}