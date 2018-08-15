package solution;

import java.util.regex.Pattern;

/**
 * 面试题20：表示数值的字符串
 * 题目：请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，
 * 字符串“+100”、“5e2”、“-123”、“3.1416”及“-1E-16”都表示数值，但“12e”、
 * “1a3.14”、“1.2.3”、“+-5”及“12e+5.4”都不是。
 */
public class NumericString {

    public static boolean isNumericString0(char[] str) {

        if (str == null || str.length == 0) {
            return false;
        }

        boolean hasSign = false, hasDecimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'e' || str[i] == 'E') {
                if (i == str.length - 1) return false;    // e后面一定要接数字(可以接+-)
                if (hasE) return false;    // 不能同时存在两个e
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // 第二次出现+-符号，则必须紧接在e之后
                if (hasSign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                // 第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if (!hasSign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                hasSign = true;
            } else if (str[i] == '.') {
                // e后面不能接小数点，小数点不能出现两次
                if (hasE || hasDecimal) return false;
                hasDecimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }
        return true;
    }

    // 方法2：使用正则表达式
    public static boolean isNumericString1(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        String s = String.valueOf(str);
        // 在匹配 . 或 { 或 [ 或 ( 或 ? 或 $ 或 ^ 或 * 这些特殊字符时，需要在前面加上 \\，
        // 比如匹配 . 时，Java 中要写为 \\.，但对于正则表达式来说就是 \.。
        return s.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
    }

    // 方法3:这个是取巧的做法，不提倡
    public static boolean isNumericString2(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        try {
            double s = Double.parseDouble(String.valueOf(str));
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
