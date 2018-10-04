package solution;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面试题50（二）：字符流中第一个只出现一次的字符
 * 题目：请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从
 * 字符流中只读出前两个字符"go"时，第一个只出现一次的字符是'g'。当从该字
 * 符流中读出前六个字符"google"时，第一个只出现一次的字符是'l'。
 *
 */
public class FirstNotRepeatingCharacterInStream {

    // 使用LinkedHashMap记住字符插入的顺序
    Map<Character, Integer> map = new LinkedHashMap<>();

    public void insert(char ch) {
        int count = 0;
        if (!map.containsKey(ch)) {
            map.put(ch, 1);
        } else {
            count = map.get(ch);
            map.put(ch, count + 1);
        }
    }

    public char firstAppearingOnce() {

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '#';
    }
}
