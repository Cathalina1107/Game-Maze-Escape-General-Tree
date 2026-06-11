package com.datastruct;
import java.util.ArrayList;

public class TreeNode {
    private String name;
    private NodeType type;
    private TreeNode parent;
    private ArrayList<TreeNode> children;

    public TreeNode(String name, NodeType type) {
        this.name = name;
        this.type = type;
        this.children = new ArrayList<TreeNode>();
    }

    public void addChild(TreeNode child) {
        this.parent = this;
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public NodeType getType() {
        return type;
    }

    public TreeNode getParent() {
        return parent;
    }

    public ArrayList<TreeNode> getChildren() {
        return children;
    }
}
