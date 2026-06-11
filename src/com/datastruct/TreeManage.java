package com.datastruct;

public class TreeManage {
    private TreeNode root;

    public TreeManage() {
        root = new TreeNode("START", NodeType.START);
        TreeNode cabang1 = new TreeNode("CABANG 1", NodeType.AREA);
        TreeNode cabang2 = new TreeNode("CABANG 2", NodeType.AREA);
        TreeNode cabang3 = new TreeNode("CABANG 3", NodeType.AREA);
        TreeNode cabang4 = new TreeNode("CABANG 4", NodeType.AREA);
        
        root.addChild(cabang1);
        root.addChild(cabang2);
        root.addChild(cabang3);
        root.addChild(cabang4);

        cabang1.addChild(new TreeNode("COIN 1", NodeType.COIN));
        cabang1.addChild(new TreeNode("COIN 2", NodeType.COIN));
        cabang1.addChild(new TreeNode("COIN 3", NodeType.COIN));
        cabang1.addChild(new TreeNode("COIN 4", NodeType.COIN));
        cabang1.addChild(new TreeNode("COIN 5", NodeType.COIN));

        cabang2.addChild(new TreeNode("COIN 1", NodeType.COIN));
        cabang2.addChild(new TreeNode("COIN 2", NodeType.COIN));
        cabang2.addChild(new TreeNode("COIN 3", NodeType.COIN));
        cabang2.addChild(new TreeNode("COIN 4", NodeType.COIN));
        cabang2.addChild(new TreeNode("COIN 5", NodeType.COIN));

        cabang3.addChild(new TreeNode("COIN 1", NodeType.COIN));
        cabang3.addChild(new TreeNode("COIN 2", NodeType.COIN));
        cabang3.addChild(new TreeNode("COIN 3", NodeType.COIN));
        cabang3.addChild(new TreeNode("COIN 4", NodeType.COIN));
        cabang3.addChild(new TreeNode("COIN 5", NodeType.COIN));

        cabang4.addChild(new TreeNode("COIN 1", NodeType.COIN));
        cabang4.addChild(new TreeNode("COIN 2", NodeType.COIN));
        cabang4.addChild(new TreeNode("COIN 3", NodeType.COIN));
        cabang4.addChild(new TreeNode("COIN 4", NodeType.COIN));
        cabang4.addChild(new TreeNode("COIN 5", NodeType.COIN));

        cabang1.addChild(new TreeNode("MONSTER 1", NodeType.MONSTER));
        cabang2.addChild(new TreeNode("MONSTER 2", NodeType.MONSTER));
        cabang3.addChild(new TreeNode("MONSTER 3", NodeType.MONSTER));
        cabang4.addChild(new TreeNode("MONSTER 4", NodeType.MONSTER));

        TreeNode Exit = new TreeNode("EXIT", NodeType.AREA);
        cabang2.addChild(Exit);
    }

    public TreeNode getRoot() {
        return root;
    }
}
