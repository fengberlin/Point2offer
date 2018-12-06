package solution;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author：Berlin
 * 用两个队列实现一个栈。
 * 题目描述：用两个队列实现一个栈。请实现它的两个函数push和pop。
 */
public class TwoQueuesStack {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public TwoQueuesStack() {
        // queue1作为pop操作的所在队列
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int value) {
        if (queue1 == null) {
            throw new RuntimeException("栈不存在。");
        }

        queue1.offer(value);
    }

    public int pop() {

        if (queue1 == null || queue2 == null) {
            throw new NullPointerException("栈不存在。");
        }

        if (queue1.size() == 0) {
            throw new RuntimeException("栈为空。");
        }

        while (queue1.size() > 1) {
            queue2.offer(queue1.remove());
        }
        int result = queue1.remove();
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return result;
    }

    public static void main(String[] args) {
        TwoQueuesStack stack = new TwoQueuesStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

        stack.push(4);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
