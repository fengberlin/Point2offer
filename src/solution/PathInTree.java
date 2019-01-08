package solution;

import java.util.ArrayList;

/**
 * 面试题34：二叉树中和为某一值的路径
 * 题目：输入一棵二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所
 * 有路径。从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class PathInTree {

    private static class BinaryTreeNode {
        private int value;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    private ArrayList<ArrayList<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> findPath(BinaryTreeNode root, int target) {

        if (root == null) {
            return result;
        }

        list.add(root.value);
        target -= root.value;
        if (target == 0 && root.left == null && root.right == null) {
            result.add(new ArrayList<>(list));
        }

        findPath(root.left, target);
        findPath(root.right, target);
        // 删去末尾的节点，因为这个节点已经不符合要求了（比如说左子节点不符合，那么要删掉之后回溯到父节点再去访问右子节点）
        list.remove(list.size() - 1);
        return result;
    }
}