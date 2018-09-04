package solution;

import java.util.*;

/**
 * 面试题40：最小的k个数
 * 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * 这8个数字，则最小的4个数字是1、2、3、4。
 */
public class KLeastNumbers {

    // 方法一：先排序然后取前k个数(不适合海量的数据) o(nlgn)
    public List<Integer> getLeastNumbers(int[] data, int k) {

        List<Integer> list = new ArrayList<>();

        if (data == null || data.length == 0 || k <= 0 || k > data.length) {
            return list;
        }

        int[] temp = data;
        Arrays.sort(temp);
        for (int i = 0; i < k; i++) {
            list.add(temp[i]);
        }

        return list;
    }

    // 方法二：使用快速排序的思想(不适合海量的数据) O(n)
    public List<Integer> getLeastNumbers1(int[] data, int k) {

        List<Integer> list = new ArrayList<>();

        if (data == null || data.length == 0 || k <= 0 || k > data.length) {
            return list;
        }

        int low = 0;
        int high = data.length - 1;
        int index = partition(data, low, high);    // 从0开始计数
        while (index != k - 1) {
            if (index > k - 1) {    // index > k - 1说明小于第index个数的数超过k-1个，则还需要在左边进行划分
                high = index - 1;
                index = partition(data, low, high);
            } else {
                low = index + 1;
                index = partition(data, low, high);
            }
        }

        for (int i = 0; i < k; i++) {
            list.add(data[i]);
        }
        return list;
    }

    // 数组的划分（快速排序的核心）
    public int partition(int[] data, int low, int high) {
        int pivot = data[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && data[j] >= pivot) {
                j--;
            }
            while (i < j && data[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(data, i, j);
            } else break;
        }
        swap(data, low, j);
        return j;
    }

    public void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    // 方法三：使用堆来存储最小的k个数
    // 通过遍历所输入的数据，然后利用最大堆，
    // 每次一个元素进来，就删除当前最大的元素
    // 并插入这个元素（这个元素比当前最大值要小）
    // 或者抛弃这个元素（这个元素比当前最大值要大），
    // 剩下的就是最小的k个数。
    // 既然要用到堆，其实也就是Java中的优先队列(PriorityQueue)
    // 适合海量的数据 O(nlgk)
    public List<Integer> getLeastNumbers2(int[] data, int k) {

        List<Integer> list = new ArrayList<>();

        if (data == null || data.length == 0 || k <= 0 || k > data.length) {
            return list;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>(k, (o1, o2) -> {
            return o2.compareTo(o1);
        });

        for (int i = 0; i < data.length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(data[i]);
            } else if (maxHeap.peek() > data[i]) {
                maxHeap.poll();
                maxHeap.offer(data[i]);
            }
        }

        for (Integer value : maxHeap) {
            list.add(value);
        }

        return list;
    }
}
