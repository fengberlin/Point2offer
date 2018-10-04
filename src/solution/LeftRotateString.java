package solution;

/**
 * 面试题58（二）：左旋转字符串
 * 题目：字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如输入字符串"abcdefg"和
 * 数字2，该函数将返回左旋转2位得到的结果"cdefgab"。
 */
public class LeftRotateString {

    // 先整体翻转，然后分成两部分分别翻转，总共翻转3次
    public String getLeftRotateString(String str, int k) {

        if (str == null || str.length() == 0) {
            return str;
        }

        if (k < 0) {
            throw new RuntimeException("invalid input.");
        }

        char[] data = str.toCharArray();
        reverse(data, 0, data.length - 1);
        reverse(data, 0, data.length - k - 1);
        reverse(data, data.length - k, data.length - 1);

        return String.valueOf(data);
    }

    public void reverse(char[] data, int start, int end) {

        if (data == null || data.length == 0 || start > end) {
            return;
        }

        // 翻转某一个区间段的字符
        while (start < end) {
            char temp = data[start];
            data[start] = data[end];
            data[end] = temp;
            start++;
            end--;
        }
    }
}
