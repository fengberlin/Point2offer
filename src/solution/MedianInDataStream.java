package solution;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 面试题41：数据流中的中位数
 * 题目：如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么
 * 中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class MedianInDataStream {

    private int count = 0;    // 数据总数
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private Queue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> {
        return o2.compareTo(o1);
    });

    // 求中位数，最简单的办法就是在一个排序的数据序列里选取中间的一个数或者中间的两个数的平均数，
    // 这时我们可以用两个堆来保持左边部分数据和右边部分数据，并且左边数据全部都要小于右边数据，
    // 这样当我们去求中位数的时候，只要把左边部分的最大值拿出来，右边部分的最小值拿出来即可。
    // 所以为了求左边的最大值，我们用最大堆保存左边数据，为了求左边的最小值，我们用最小堆保存右边数据。
    // 首先要保证两部分数据是平均分配的，即两个堆中的数据的数目之差不超过1.所以，可以在数据的数目是偶数
    // 的时候将新数据插入到最小堆，否则插入最大堆(反过来也可以，但是在奇数个数据的时候最后返回的是最大堆的最大值)。
    // 还要保证最大堆的数据全部都要小于最小堆的数据，在数据的数目是偶数的时候，当新数据大于最大堆的一些数据的时候，
    // 我们可以先把这个数据插入到最大堆中，然后把最大堆最大的数据拿出来再把它插入最小堆。反之亦然。
    public void insert(Integer num) {

        if ((count & 1) == 0) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
        } else {
            minHeap.offer(num);
            maxHeap.offer(minHeap.poll());
        }
        count++;
    }

    public Double getMedian() {

        if ((count & 1) == 0) {
            return Double.valueOf((maxHeap.peek() + minHeap.peek()) / 2.0);
        } else {
            return Double.valueOf(minHeap.peek());
        }
    }
}
