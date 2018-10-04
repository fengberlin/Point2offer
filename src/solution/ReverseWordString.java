package solution;

import java.util.LinkedList;

/**
 * 面试题58（一）：翻转单词顺序
 * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。
 * 为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student."，
 * 则输出"student. a am I"。
 */
public class ReverseWordString {

    // 整体思路是整个字符串先翻转，然后再单独翻转每个单词
    public String reverse(String str) {

        if (str == null || str.length() == 0) {
            return str;
        }

        char[] data = str.toCharArray();
        reverseCore(data, 0, data.length - 1);
        int start = 0;    // 记录要翻转的单词的开始位置
        int end = 0;    // 记录要翻转的单词的结束位置
        int i = 0;
        while (i < data.length) {
            while (i < data.length && data[i] == ' ') {    // 跳过前面的空格
                i++;
            }
            start = end = i;
            while (i < data.length && data[i] != ' ') {    // 记录单词的位置
                i++;
                end++;
            }
            reverseCore(data, start, end - 1);    // 翻转单词
        }

        return String.valueOf(data);
    }

    public void reverseCore(char[] data, int low, int high) {

        if (data == null || data.length == 0 || low > high) {
            return;
        }

        // 翻转某一个区间段的字符
        while (low < high) {
            char temp = data[low];
            data[low] = data[high];
            data[high] = temp;
            low++;
            high--;
        }
    }
}
