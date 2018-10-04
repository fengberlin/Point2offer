package solution;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 面试题50（一）：字符串中第一个只出现一次的字符
 * 题目：在字符串中找出第一个只出现一次的字符。如输入"abaccdeff"，则输出'b'。
 *
 * 牛客网的描述：在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,
 * 并返回它的位置, 如果没有则返回 -1（需要区分大小写）。
 *
 * 以牛客网的题目来做
 */
public class FirstNotRepeatingCharacter {

    // 使用LinkedHashMap保持插入的顺序，key为字符本身，value为出现的次数，
    // 通过每个字符的出现次数是否为1来返回下标值。
    public int getThatCharacterIndex(String str) {

        if (str == null || str.length() == 0) {
            return -1;
        }

        int count = 0;
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), 1);
            } else {
                count = map.get(str.charAt(i));
                map.put(str.charAt(i), count + 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstNotRepeatingCharacter().getThatCharacterIndex("googgle"));
    }
}
