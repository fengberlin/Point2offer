package solution;

/**
 * 面试题46：把数字翻译成字符串
 * 题目：给定一个数字，我们按照如下规则把它翻译为字符串：0翻译成"a"，1翻
 * 译成"b"，……，11翻译成"l"，……，25翻译成"z"。一个数字可能有多个翻译。例
 * 如12258有5种不同的翻译，它们分别是"bccfi"、"bwfi"、"bczi"、"mcfi"和
 * "mzi"。请编程实现一个函数用来计算一个数字有多少种不同的翻译方法。
 */
public class TranslateNumbersToString {

    public int getTranslationCount(int number) {

        if (number < 0) {
            return 0;
        }

        String str = String.valueOf(number);
        return count(str);
    }

    public int count(String str) {

        int[] counts = new int[str.length()];
        int count = 0;

        for (int i = str.length() - 1; i >= 0; i++) {
            count = 0;
            if (i < str.length() - 1) {
                count = counts[i + 1];
            } else {
                count = 1;
            }

            if (i < str.length() - 1) {
                int digit1 = str.charAt(i) - '0';
                int digit2 = str.charAt(i + 1) - '0';
                int converted = digit1 * 10 + digit2;
                if (converted >= 10 && converted <= 25) {
                    if (i < str.length() - 2) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }

            counts[i] = count;
        }

        count = counts[0];
        counts = null;
        return count;
    }
}
