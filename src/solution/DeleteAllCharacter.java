package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 从第一个字符串中删除第二个字符串中出现过的所有字符。
 * 例如第一个字符串"Hello World"，第二个字符串"old"，
 * 删除后，第一个字符串变为"He Wr"。
 */
public class DeleteAllCharacter {

    public String getAfterDeletingCharacter(String str1, String str2) {

        if (str1 == null) {
            return null;
        }

        if (str2 == null || str2.length() == 0) {
            return str1;
        }

        // 用一个HashMap存储第二个字符串
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str2.length(); i++) {
            map.put(str2.charAt(i), i);
        }

        StringBuilder sb = new StringBuilder();
        // 遍历第一个字符串，如果遍历到的字符不在map中，则append到StringBuilder中
        for (int i = 0; i < str1.length(); i++) {
            if (!map.containsKey(str1.charAt(i))) {
                sb.append(str1.charAt(i));
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DeleteAllCharacter().getAfterDeletingCharacter("Hello World", "old"));
    }
}
