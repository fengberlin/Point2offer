package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 面试题32（三）：之字形打印二叉树
 * 题目：请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺
 * 序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，
 * 其他行以此类推。
 */
public class PrintTreeInZigzag {

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

    public List<List<Integer>> print(BinaryTreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        // 标记是否按这个顺序来打印
        boolean left2Right = true;
        // 记录每层的节点个数
        int size = 1;

        while (!queue.isEmpty()) {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode node = queue.poll();
                if (left2Right) {
                    list.addLast(node.value);
                } else {
                    list.addFirst(node.value);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
            size = queue.size();
            left2Right = !left2Right;
        }
        return result;
    }
}
