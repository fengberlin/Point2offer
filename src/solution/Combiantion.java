package solution;

import java.util.*;

public class Combiantion {

    public static List<String> combine(char[] str) {

        // 共有2^n - 1种组合，1表示选择这个字符，0表示不选择，例如有字符串abc，abc -> 111，a -> 100...
        List<String> list = new ArrayList<>();
        for (int i = 1; i < (1 << str.length); i++) {
            String result = "";
            for (int j = 0; j < str.length; j++) {
                if ((i & (1 << j)) != 0) {
                    result += str[j];
                }
            }
            list.add(result);
        }
        return list;
    }

    public static void main(String[] args) {
        List<String> list = combine(new char[]{'a', 'b', 'c'});
        System.out.println(list);
    }
}
