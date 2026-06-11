import com.datastruct.*;
public class Main {
    public static void main(String[] args) {
        TreeManage tree = new TreeManage();
        TreeNode root = tree.getRoot();
        System.out.println("root: " + root.getName());
        for(TreeNode child : root.getChildren()) {
            System.out.println("child: " + child.getName());
        }
        for(TreeNode child : root.getChildren()) {
            System.out.println(child.getName());
            for(TreeNode child2 : child.getChildren()) {
                System.out.println("=" + child2.getName());
            }
        }
    }
}
