package solution;

import java.util.Arrays;

/**
 * 面试题45：把数组排成最小的数
 * 题目：输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼
 * 接出的所有数字中最小的一个。例如输入数组{3, 32, 321}，则打印出这3个数
 * 字能排成的最小数字321323。
 */
public class PrintMinNumber {

    /**
     * 解题思路：
     * 先将整型数组转换成String数组，然后将String数组排序，最后将排好序的字符串数组拼接出来。关键就是制定排序规则。
     * 排序规则如下：
     * 若ab > ba 则 a > b，
     * 若ab < ba 则 a < b，
     * 若ab = ba 则 a = b；
     * 即对{3, 32, 321}来说，332 > 323即ab < ba，所以排序后应该是32, 3(a < b)
     */
    public String printMinNumber(int[] numbers) {

        if (numbers == null || numbers.length == 0) {
            return "";
        }

        String[] data = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            data[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(data, (s1, s2) -> {
            String str1 = s1 + s2;
            String str2 = s2 + s1;
            return str1.compareTo(str2);
        });

        StringBuilder sb = new StringBuilder(data.length);
        for (int i = 0; i < data.length; i++) {
            sb.append(data[i]);
        }

        return sb.toString();
    }
}


