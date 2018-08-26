package solution;

import java.util.LinkedList;

/**
 * 面试题31：栈的压入、弹出序列
 * 题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
 * 否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
 * 5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
 * 4、3、5、1、2就不可能是该压栈序列的弹出序列。
 *
 *
 * 借用一个辅助的栈，遍历压栈顺序，先将第一个元素放入栈中，然后判断栈顶元素
 * 是不是出栈顺序的第一个元素，如果不相等，那么我们继续压栈，直到相等以后开
 * 始出栈，出栈一个元素，则将出栈顺序向后移动一位，直到不相等，这样循环等压
 * 栈顺序遍历完成，如果辅助栈还不为空，说明弹出序列不是该栈的弹出顺序。
 */
public class StackPushPopOrder {

    public boolean isPopOrder(int[] pushA,int[] popA) {
        if (pushA.length == 0 || popA.length == 0) {
            return false;
        }

        LinkedList<Integer> stack = new LinkedList<>();

        //用于标识弹出序列的位置
        int popIndex = 0;

        for (int i = 0; i < popA.length; i++) {
            stack.push(pushA[i]);
            //如果栈不为空，且栈顶元素等于弹出序列
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]) {
                //出栈
                stack.pop();
                //弹出序列向后一位
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
