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
public class PreOrderTraversal {

    //递归法
    public List<Integer> preOrderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    //迭代法
    public List<Integer> preOrderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            result.add(tmp.val);
            if (tmp.right != null) {
                stack.push(tmp.right);
            }
            if (tmp.left != null) {
                stack.push(tmp.left);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        System.out.println(preOrderTraversal.preOrderTraversal1(root));
        System.out.println(preOrderTraversal.preOrderTraversal2(root));
    }

}
