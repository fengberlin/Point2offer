package solution;

import java.util.LinkedList;

/**
 * Problem 9：用两个栈实现队列。
 * 题目描述：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
 * 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
public class TwoStacksQueue {

    private LinkedList<Integer> stack1;
    private LinkedList<Integer> stack2;

    public TwoStacksQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        if (stack1 == null) {
            throw new RuntimeException("队列不存在。");
        }

        stack1.push(value);    // 将元素入队时，利用的是stack1。

    }

    public int deleteHead() {
        if (stack2 == null || stack1 == null) {
            throw new NullPointerException("队列不存在。");
        }

        if (stack1.size() == 0 && stack2.size() == 0) {
            throw new RuntimeException("队列为空。");
        }

        if (stack2.size() == 0) {    // 当stack2为空时，此时需要将stack1中的所有元素pop出来并push进stack2里面。
            while (stack1.size() > 0) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        TwoStacksQueue queue = new TwoStacksQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());
    }
}
