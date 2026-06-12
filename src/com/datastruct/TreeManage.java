package com.datastruct;

import java.awt.Rectangle;
import java.util.*;

public class TreeManage {

    public static ArrayList<TreeNode> cariJalanTercepat(
            int startX,
            int startY,
            int size,
            ArrayList<Rectangle> walls,
            ArrayList<Rectangle> enemies,
            Rectangle exit
    ) {
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        TreeNode root = new TreeNode(startX, startY, "START", null);

        queue.add(root);
        visited.add(startX + "," + startY);

        int step = 10;

        int[][] gerak = {
                {0, -step},   // ATAS
                {0, step},    // BAWAH
                {-step, 0},   // KIRI
                {step, 0}     // KANAN
        };

        String[] namaArah = {
                "ATAS",
                "BAWAH",
                "KIRI",
                "KANAN"
        };

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            Rectangle player = new Rectangle(current.x, current.y, size, size);

            if (player.intersects(exit)) {
                return ambilPath(current);
            }

            for (int i = 0; i < gerak.length; i++) {
                int nx = current.x + gerak[i][0];
                int ny = current.y + gerak[i][1];

                String key = nx + "," + ny;

                if (!visited.contains(key)
                        && bisaLewat(nx, ny, size, walls, enemies)) {

                    TreeNode child = new TreeNode(
                            nx,
                            ny,
                            namaArah[i],
                            current
                    );

                    current.addChild(child);
                    queue.add(child);
                    visited.add(key);
                }
            }
        }

        return new ArrayList<>();
    }

    private static boolean bisaLewat(
            int x,
            int y,
            int size,
            ArrayList<Rectangle> walls,
            ArrayList<Rectangle> enemies
    ) {
        Rectangle player = new Rectangle(x, y, size, size);

        for (Rectangle wall : walls) {
            if (player.intersects(wall)) {
                return false;
            }
        }

        for (Rectangle enemy : enemies) {
            if (player.intersects(enemy)) {
                return false;
            }
        }

        return true;
    }
    private static ArrayList<TreeNode> ambilPath(TreeNode node) {
    ArrayList<TreeNode> path = new ArrayList<>();

    while (node != null) {
        path.add(node);
        node = node.parent;
    }

    Collections.reverse(path);
    return path;
}

    public static void tampilkanTreeJalur(ArrayList<TreeNode> path) {
    System.out.println("=== GENERAL TREE JALUR TERCEPAT ===");

    if (path.isEmpty()) {
        System.out.println("Tidak ada jalan ke exit.");
        return;
    }

    System.out.println("START");

    for (int i = 0; i < path.size() - 1; i++) {
        TreeNode current = path.get(i);
        TreeNode next = path.get(i + 1);

        System.out.println();
        System.out.println(current.arah + " memiliki cabang:");

        for (TreeNode child : current.children) {
            if (child.x == next.x && child.y == next.y) {
                System.out.println("├── " + child.arah + "  <-- DIPILIH");
            } else {
                System.out.println("├── " + child.arah);
            }
        }
    }

    System.out.println();
    System.out.println("EXIT ditemukan");
    System.out.println("Total langkah: " + (path.size() -1));
}
}


