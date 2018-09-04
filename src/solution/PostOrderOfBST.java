package solution;

/**
 * 面试题33：二叉搜索树的后序遍历序列
 * 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 *
 * BST的后序序列的合法序列是，对于一个序列S，最后一个元素是x （也就是根），
 * 如果去掉最后一个元素的序列为T，那么T满足：T可以分成两段，前一段（左子树）
 * 小于x，后一段（右子树）大于x，且这两段（子树）都是合法的后序序列。完美的递归定义。
 */
public class PostOrderOfBST {

    public boolean verifyPostOrderOfBST(int[] sequence) {

        if (sequence == null || sequence.length <= 0) {
            return false;
        }

        return judge(sequence, 0, sequence.length - 1);

    }

    public boolean judge(int[] sequence, int start, int end) {

        // 递归条件
        if (start >= end) {
            return true;
        }

        int i = start;
        while (sequence[i] < sequence[end]) {
            i++;
        }

        for (int j = i; j < end; j++) {
            if (sequence[j] < sequence[end]) {
                return false;
            }
        }

        return judge(sequence, start, i - 1) && judge(sequence, i, end - 1);
    }
}
