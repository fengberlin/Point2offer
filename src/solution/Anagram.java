package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 判断两个单词是否互为变位词。
 * 变位词：如果两个单词中出现的字母相同，并且每个字母出现的次数也相同，那么这两个单词互为变位词。
 * 例子：silent和listen，evil和live
 */
public class Anagram {

    public boolean isAnagram(String str1, String str2) {

        if (str1 == null || str2 == null) {
            return false;
        }

        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!map.containsKey(str1.charAt(i))) {
                map.put(str1.charAt(i), 1);
            } else {
                count = map.get(str1.charAt(i));
                map.put(str1.charAt(i), ++count);
            }
        }

        for (int i = 0; i < str2.length(); i++) {
            if (map.containsKey(str2.charAt(i))) {
                count = map.get(str2.charAt(i));
                map.put(str2.charAt(i), --count);
            } else {
                return false;
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Anagram().isAnagram("silent", "listen"));
        System.out.println(new Anagram().isAnagram("evil", "live"));
        System.out.println(new Anagram().isAnagram("hollle", "hello"));
    }
}
