package tech.jiangchen.struct;

/**
 * @author jiangchen
 * @date 2021/01/21
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode() {
        this.val = 1;
        this.left = new TreeNode(2);
        this.right = new TreeNode(3);
        this.left.left = new TreeNode(4);
        this.left.right = new TreeNode(5);
        this.right.left = new TreeNode(6);
        this.right.right = new TreeNode(7);
    }
}
