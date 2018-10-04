package solution;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 删除字符串中所有重复出现的字符。
 * 例如，字符串"google"，删除后得到"gole"
 */
public class DeleteRepeatingCharacter {

    public String getAfterDeletingRepeatingCharacter(String str) {

        // 用LinkedHashMap保持插入的顺序，如果map中之前不存在某个字符，则把它添加进去
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (!map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            sb.append(entry.getKey());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DeleteRepeatingCharacter().getAfterDeletingRepeatingCharacter("google"));
    }
}
