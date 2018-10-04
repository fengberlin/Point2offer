package solution;

/**
 * 面试题48：最长不含重复字符的子字符串
 * 题目：请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子
 * 字符串的长度。假设字符串中只包含从'a'到'z'的字符。
 * 例如：在字符串"arabcacfr"中，最长的不包含重复字符的子字符串是"acfr"，长度为4。
 */
public class LongestSubstringWithoutDup {

    // 这是一个动态规划问题，定义函数f(i)表示以第i个字符结尾的不包含重复字符的子字符串的最长长度。
    // (一)如果第i个字符之前没有出现过，则f(i) = f(i - 1) + 1。
    // (二)如果第i个字符之前出现过，先计算第i个字符和它上次出现在字符串中的位置的距离，记为d，则有两种情况：
    // 1.如果d小于或等于f(i - 1)，则意味着第i个字符上次出现在f(i - 1)对应的最长子字符串中，因此f(i)变为d，f(i)=d，
    // 同时也意味着在第i个字符出现两次所夹的子字符串中再也没有其他重复的字符了。
    // 2.如果d大于f(i - 1)，此时说明第i个字符上次出现在f(i - 1)对应的最长子字符串之前，因此f(i) = f(i - 1) + 1。
    public int lengthOfLongestSubstringWithoutDup(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        int curLength = 0;
        int maxLength = 0;

        // position用来存储每个字符上次出现在字符串中位置的下标
        int[] position = new int[26];
        for (int i = 0; i < position.length; i++) {
            position[i] = -1;    // -1表示该元素对应的字符在字符串中还没有出现过
        }

        for (int i = 0; i < str.length(); i++) {
            // preIndex记录下字符之前在字符串中位置的下标
            int preIndex = position[str.charAt(i) - 'a'];
            // i - preIndex表示当前字符到之前在字符串出现过的位置的距离
            // 对应着(一)和(二.2)
            if ((preIndex < 0) || (i - preIndex > curLength)) {
                curLength++;
            } else {
                if (curLength > maxLength) {
                    maxLength = curLength;
                }
                curLength = i - preIndex;
            }
            position[str.charAt(i) - 'a'] = i;
        }

        if (curLength > maxLength) {
            maxLength = curLength;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(
                new LongestSubstringWithoutDup().
                        lengthOfLongestSubstringWithoutDup("arabcacfr"));
    }
}
