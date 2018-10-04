package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题53（一）：数字在排序数组中出现的次数
 * 题目：统计一个数字在排序数组中出现的次数。例如输入排序数组{1, 2, 3, 3,
 * 3, 3, 4, 5}和数字3，由于3在这个数组中出现了4次，因此输出4
 */
public class FrequencyOfNumber {

    // 方法一：使用HashMap
    public int getFrequencyOfNumber(int[] data, int number) {

        if (data == null || data.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int count;
        for (int i = 0; i < data.length; i++) {
            if (!map.containsKey(data[i])) {
                map.put(data[i], 1);
            } else {
                count = map.get(data[i]);
                map.put(data[i], count + 1);
            }
        }

        int result;
        if (!map.containsKey(number)) {
            result = 0;
        } else {
            result = map.get(number);
        }

        return result;
    }

    // 方法二：一看到是有序的数组，我们就可以尝试使用二分查找算法
    // 这个方法非常地巧妙，因为输入的数都是整数，所以我们构造一个函数，
    // 去寻找比要查找的目标小0.5或者大0.5的目标，因为时不可能找到这个目标的，
    // 所以它最后只是找到了最左边的小于要寻找的目标的数的下标和最右边的大于要
    // 寻找的目标的数的下标，两下标相减就是重复的个数。
    public int getFrequencyOfNumber1(int[] data, int number) {

        if (data == null || data.length == 0) {
            return 0;
        }

        return search(data, number + 0.5) - search(data, number - 0.5);
    }

    public int search(int[] data, double num) {
        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            if (data[mid] < num) {
                start = mid + 1;
            } else if (data[mid] > num) {
                end = mid - 1;
            }
        }
        return start;
    }

    // 方法3：也是一个基于二分查找算法的思想
    public int getFrequencyOfNumber2(int[] data, int number) {

        if (data == null || data.length == 0) {
            return 0;
        }

        int firstIndex = getFirstNumIndex(data, number, 0, data.length - 1);
        int lastIndex = getLastNumIndex(data, number, 0, data.length - 1);
        if (firstIndex == -1 || lastIndex == - 1) {
            return 0;
        } else {
            return lastIndex - firstIndex + 1;
        }
    }

    // 递归和循环写法
    public int getFirstNumIndex(int[] data, int number, int start, int end) {

//        if (start > end) {
//            return -1;
//        }
//
//        int mid = (start + end) >> 1;
//        if (data[mid] > number) {
//            return getFirstNumIndex(data, number, start, mid - 1);
//        } else if (data[mid] < number) {
//            return getFirstNumIndex(data, number, mid + 1, end);
//        } else if ((mid - 1 >= 0) && (data[mid - 1] == number)) {
//            return getFirstNumIndex(data, number, start, mid - 1);
//        } else {
//            return mid;
//        }
        int length = data.length;
        int mid;
        while (start <= end) {
            mid = ((end - start) >> 1) + start;
            if (data[mid] > number) {
                end = mid - 1;
            } else if (data[mid] < number) {
                start = mid + 1;
            } else if ((mid - 1 >= 0) && data[mid - 1] == number) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    // 递归和循环写法
    public int getLastNumIndex(int[] data, int number, int start, int end) {

//        int length = data.length;
//        int mid;
//        while (start <= end) {
//            mid = (start + end) >> 1;
//            if (data[mid] > number) {
//                end = mid - 1;
//            } else if (data[mid] < number) {
//                start = mid + 1;
//            } else if ((mid + 1 < length) && data[mid + 1] == number) {
//                start = mid + 1;
//            } else {
//                return mid;
//            }
//        }
//        return -1;

        if (start > end) {
            return -1;
        }

//        int mid = (start + end) >> 1;
        int mid = ((end - start) >> 1) + start;    // 防止加法运算溢出
        if (data[mid] > number) {
            return getLastNumIndex(data, number, start, mid - 1);
        } else if (data[mid] < number) {
            return getLastNumIndex(data, number, mid + 1, end);
        } else if ((mid + 1 < data.length) && (data[mid + 1] == number)) {
            return getLastNumIndex(data, number, mid + 1, end);
        } else {
            return mid;
        }

    }

    public static void main(String[] args) {

        int[] data = {1, 2, 3, 3, 3, 3, 6, 9};
        System.out.println(new FrequencyOfNumber().getFrequencyOfNumber2(data, 3));
    }
}
