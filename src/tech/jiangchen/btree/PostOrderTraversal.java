package tech.jiangchen.btree;

import tech.jiangchen.struct.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jiangchen
 * @date 2021/01/21
 */
public class PostOrderTraversal {

    public List<Integer> postOrderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }


    public List<Integer> postOrderTraversal2(TreeNode root) {

        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        PostOrderTraversal postOrderTraversal = new PostOrderTraversal();
        System.out.println(postOrderTraversal.postOrderTraversal1(root));
        System.out.println(postOrderTraversal.postOrderTraversal2(root));
    }

}
