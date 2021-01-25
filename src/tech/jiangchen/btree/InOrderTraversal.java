package tech.jiangchen.btree;

import tech.jiangchen.struct.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiangchen
 * @date 2021/01/21
 */
public class InOrderTraversal {

    //递归法中序遍历
    public List<Integer> inOrderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


    //迭代法中序遍历
    public List<Integer> inOrderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        InOrderTraversal inOrderTraversal = new InOrderTraversal();
        System.out.println(inOrderTraversal.inOrderTraversal1(root));
        System.out.println(inOrderTraversal.inOrderTraversal2(root));
    }
}
