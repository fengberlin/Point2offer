package solution;

/**
 * Author：Berlin
 * Problem 7：重建二叉树
 * 题目描述：输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输
 * 入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列
 * {1, 2, 4, 7, 3, 5, 6, 8}和中序遍历序列{4, 7, 2, 1, 5, 3, 8, 6}，则重建出
 * 二叉树并输出它的根结点。
 */
public class RebuildBinaryTree {

    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static TreeNode rebuildCore(int[] PreOrder, int startPreOrder,
                                       int endPreOrder, int[] InOrder, int startInOrder, int endInOrder) {
        
        if (PreOrder == null || InOrder == null || PreOrder.length == 0 || InOrder .length == 0) {
            return null;
        }
        
        if (startPreOrder > endPreOrder || startInOrder > endInOrder) {
            return null;
        }
        
        TreeNode root = new TreeNode(PreOrder[startPreOrder]);

        for (int i = startInOrder; i <= endInOrder; i++) {
            // 寻找中序序列中与前序序列中第一个相等的那个元素即根结点，然后就可以递归地创建左、右子树
            if (InOrder[i] == PreOrder[startPreOrder]) {
                // 首先找到前序序列中的第一个元素即为根结点，
                // 那么的话对应于中序序列，那个结点的左边部分为左子树的结点，右边部分为右子树的结点。
                // 所以我们可以在前序序列中划分左右子树的范围，即startPreOrder + 1到startPreOrder + (i - startInOrder)为左子树部分，
                // startPreOrder + (i - startInOrder) + 1到endPreOrder为右子树的部分。
                // 其中i - startInOrder计算的是在中序序列中左子树的结点的个数。
                root.left = rebuildCore(PreOrder, startPreOrder + 1,
                        startPreOrder + (i - startInOrder), InOrder, startInOrder, i - 1);
                root.right = rebuildCore(PreOrder, startPreOrder + (i - startInOrder) + 1,
                        endPreOrder, InOrder, i + 1, endInOrder);
                break;
            }
        }

        return root;
    }

    public static TreeNode rebuild(int[] PreOrder, int[] InOrder) {

        TreeNode root = rebuildCore(PreOrder, 0, PreOrder.length - 1,
                InOrder, 0, InOrder.length - 1);

        return root;
    }


}
