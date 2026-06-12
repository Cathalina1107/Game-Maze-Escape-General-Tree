package com.datastruct;

import java.util.ArrayList;

public class TreeNode {
    int x, y;
    String arah;
    TreeNode parent;
    ArrayList<TreeNode> children = new ArrayList<>();

    public TreeNode(int x, int y, String arah, TreeNode parent) {
        this.x = x;
        this.y = y;
        this.arah = arah;
        this.parent = parent;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }
}