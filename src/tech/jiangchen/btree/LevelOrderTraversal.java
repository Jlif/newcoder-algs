package tech.jiangchen.btree;

import tech.jiangchen.struct.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author jiangchen
 * @date 2021/01/22
 */
public class LevelOrderTraversal {

    ArrayDeque<TreeNode> tmpQueue = new ArrayDeque<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        tmpQueue.add(root);
        while (!tmpQueue.isEmpty()) {
            subProcess(tmpQueue.clone());
        }
        return result;
    }

    public void subProcess(ArrayDeque<TreeNode> queue) {
        List<Integer> tmpResult = new LinkedList<>();
        tmpQueue.clear();
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.remove();
            tmpResult.add(tmp.val);
            if (tmp.left != null) {
                tmpQueue.add(tmp.left);
            }
            if (tmp.right != null) {
                tmpQueue.add(tmp.right);
            }
        }
        result.add(tmpResult);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        LevelOrderTraversal levelOrderTraversal = new LevelOrderTraversal();
        System.out.println(levelOrderTraversal.levelOrder(root));
    }
}
