package solution;

public class LeafNodeNum {

    private class BinaryTreeNode {
        int value;
        BinaryTreeNode left;
        BinaryTreeNode right;
    }

    public int leafNodeNum(BinaryTreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        return leafNodeNum(root.left) + leafNodeNum(root.right);
    }
}
