package solution;

/**
 * 面试题37：序列化二叉树
 * 题目：请实现两个函数，分别用来序列化和反序列化二叉树。
 */
public class SerializeBinaryTree {

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

    int index = -1;

    public String serialize(BinaryTreeNode root) {

        StringBuilder sb = new StringBuilder();

        if (root == null) {
            return sb.append("#,").toString();
        }

        sb.append(root.value + ",");
        sb.append(serialize(root.left));
        sb.append(serialize(root.right));

        return sb.toString();
    }

    public BinaryTreeNode deSerialize(String tree) {

        index++;

        String[] values = tree.split(",");
        BinaryTreeNode root = null;
        if (!values[index].equals("#")) {
            root = new BinaryTreeNode(Integer.valueOf(values[index]));
            root.left = deSerialize(tree);
            root.right = deSerialize(tree);
        }

        return root;
    }
}
