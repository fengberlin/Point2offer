package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 面试题39：数组中出现次数超过一半的数字
 * 题目：数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例
 * 如输入一个长度为9的数组{1, 2, 3, 2, 2, 2, 5, 4, 2}。由于数字2在数组中
 * 现了5次，超过数组长度的一半，因此输出2。
 */
public class MoreThanHalf {

    // 方法一：因为数组中有一个数字出现的次数超过数组长度的一半，
    // 所以我们只需要进行一个排序，然后判断中间的那个数的出现次数
    // 有没有出现的次数超过数组长度的一半即可。
    // O(nlgn)
    public int moreThanHalf(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        Arrays.sort(numbers);    // 这是一个缺点，因为会改变原本数组的结构
        int result = numbers[numbers.length / 2];

        int times = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (result == numbers[i]) {
                times++;    // 记录下那个数字的出现的次数
            }
        }
        if (times > (numbers.length / 2)) {
            return result;
        } else {
            return 0;
        }
    }

    // 方法二：使用HashMap存储数字及其出现的次数
    public int moreThanHalf1(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                map.put(numbers[i], 1);
            } else {
                int count = map.get(numbers[i]);
                map.put(numbers[i], count + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int number = entry.getKey();
            int value = entry.getValue();
            if (value > (numbers.length / 2)) {
                return number;
            }
        }

        return 0;
    }

    /**
     * 方法三：数组中有一个数字出现的次数超过数组长度的一半,
     * 也就是说它出现的次数比其他所有数字出现次数之和还要多。
     * 我们在遍历数组的时候保存两个值，分别是数字本身和它出现的次数。
     * 当我们遍历到下一个数字的时候，如果下一个数字和我们之前保存的
     * 那个数字相同，则次数加1，否则减1。如果次数减到0，则保存下一个
     * 数字，并把次数设为1。由于要找的那个数字出现的次数比其他所有数字
     * 出现次数之和还要多，所以那个数字肯定就是最后一次把次数设为1时对应的数字。

     * 采用阵地攻守的思想：第一个数字作为第一个士兵，守阵地；count = 1；
     * 遇到相同元素，count++;遇到不相同元素，即为敌人，同归于尽,count--；
     * 当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，
     * 到最后还留在阵地上的士兵，有可能是主元素。
     * 再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
     */
    public int moreThanHalf2(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return 0;
        }

        int result = numbers[0];
        int times = 1;
        for (int i = 1; i < numbers.length; i++) {

            if (times == 0) {
                result = numbers[i];
                times = 1;
            } else if (result != numbers[i]) {
                times--;
            } else {
                times++;
            }
        }

        int count = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (result == numbers[i]) {
                count++;
            }
        }
        if (count > (numbers.length / 2)) {
            return result;
        } else {
            return 0;
        }
    }

}
