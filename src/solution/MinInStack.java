package solution;

import java.util.LinkedList;

/**
 * 面试题30：包含min函数的栈
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min
 * 函数。在该栈中，调用min、push及pop的时间复杂度都是O(1)。
 *
 * 使用一个辅助栈来保存数据栈的最小值
 */
public class MinInStack {

    private LinkedList<Integer> data;
    private LinkedList<Integer> min;

    public MinInStack() {
        data = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(Integer item) {
        data.push(item);
        if (min.size() == 0 || min.peek() > item) {
            min.push(item);
            return;
        }
        if (min.peek() <= item) {
            min.push(min.peek());
            return;
        }
    }

    public Integer pop() {
        if (data.size() > 0 && min.size() > 0) {
            min.pop();
            return data.pop();
        }
        return null;
    }

    public Integer min() {
        if (data.size() > 0 && min.size() > 0) {
            return min.pop();
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedList<Integer> data = new LinkedList<>();
        LinkedList<Integer> min = new LinkedList<>();

        MinInStack minInStack = new MinInStack();
        minInStack.push(3);
        minInStack.push(4);
        minInStack.push(2);
        minInStack.push(1);
        System.out.println(minInStack.min());
        System.out.println(minInStack.pop());
        System.out.println(minInStack.min());
        System.out.println(minInStack.pop());
        minInStack.push(0);
        System.out.println(minInStack.min());
        System.out.println(minInStack.pop());
    }
}