package solution;

import java.util.*;

/**
 * 面试题59（一）：滑动窗口的最大值
 * 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
 * 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
 * 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}
 */
public class MaxValueInSlidingWindow {

    // 方法一
    // 使用优先队列保存每个窗口的元素并可以得到每个窗口的最大元素值
    public List<Integer> getMaxValueInSlidingWindow(int[] data, int n) {

        List<Integer> list = new ArrayList<>();
        if (data == null || data.length == 0 || n <= 0 || n > data.length) {
            return list;
        }

        Queue<Integer> queue = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int i = 0; i <= data.length - n; i++) {
            for (int j = i; j < n + i; j++) {
                queue.offer(data[j]);
            }
            list.add(queue.peek());
            queue.clear();
        }
        return list;
    }

    // 方法二
    // 这里并不把滑动窗口的每个数值都存入队列，而是只把有可能成为滑动窗口最大值的数值存入一个双端队列
    public List<Integer> getMaxValueInSlidingWindow1(int[] data, int n) {

        List<Integer> list = new ArrayList<>();
        if (data == null || data.length == 0 || n <= 0 || n > data.length) {
            return list;
        }

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < data.length; i++) {
            while (!deque.isEmpty() && data[deque.peekLast()] <= data[i]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && (i - deque.peekFirst() + 1) > n) {
                deque.pollFirst();
            }
            deque.offerLast(i);
            if (i + 1 >= n) {
                list.add(data[deque.peekFirst()]);
            }
        }

        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new MaxValueInSlidingWindow().getMaxValueInSlidingWindow1(
                new int[]{2, 3, 4, 2, 6, 2, 5, 1}, 3);
        for (Integer v : list) {
            System.out.print(v + " ");
        }
    }
}
