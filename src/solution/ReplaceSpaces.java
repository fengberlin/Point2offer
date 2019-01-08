package solution;

/**
 * Author: Berlin
 * Problem 5：替换空格
 * 题目描述：请实现一个函数，把字符串中的每个空格替换成"%20"。
 * 例如输入“We are happy.”，则输出“We%20are%20happy.”。
 */
public class ReplaceSpaces {

    // 方法1：时间复杂度为O(n)，空间复杂度为O(n)。
    // 这个方法简单易懂。
    public static void replaceBlank0(String str) {

        if (str == null || str.length() == 0) {
            return;
        }

        // 申请一个StringBuilder，这时一个可变的对象，用于存储添加列字符串%20之后的那个字符串。
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                sb.append("%20");    // 遇到空格则用字符串%20替换。
            } else {
                sb.append(str.charAt(i));    // 否则直接附加上那个字符。
            }
        }

        System.out.println(sb.toString());
    }

    // 方法2：时间复杂度为O(n)，空间复杂度为O(n)。
    // 由于在Java中，字符串类型是不可变的对象，所以需要申请额外的空间。
    // 该方法相当于使用两个指针，一个指针p1指向原始字符串的末尾位置，另一个指针p2指向添加了字符串%20后的那个字符串的末尾位置，
    // 然后，p1向字符串的头位置移动指针，如果遇到的字符不是空格字符，就把那个字符复制到p2指向的位置，同时p2跟随p1的方向移动一个位置，
    // 如果遇到空格，p2所处位置指向的下一个位置开始分别填充字符0、2、%，然后p1再移动一个位置。
    public static void replaceBlank1(String str) {

        if (str == null || str.length() == 0) {
            return;
        }

        int spaceNum = 0;

        // 计算字符串中的空格数。
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                spaceNum++;
            }
        }

        // 如果没有空格，就直接输出原字符串。
        if (spaceNum == 0) {
            System.out.println(str);
            return;
        }

        int oldIndex = str.length() - 1;
        int newLength = str.length() + spaceNum * 2;    // 计算添加了%20后的字符串的长度。因为本来空格占一个空间，然后%20需要3个空间，所以乘以2
        int newIndex = newLength - 1;

        StringBuilder sb = new StringBuilder(str);    // 这里需要用原字符串初始化StringBuilder对象，这样才能在基于原字符串上添加%20
        sb.setLength(newLength);

        while (oldIndex >= 0 && oldIndex < newIndex) {
            if (str.charAt(oldIndex) == ' ') {
                sb.setCharAt(newIndex--, '0');
                sb.setCharAt(newIndex--, '2');
                sb.setCharAt(newIndex--, '%');
            } else {
                sb.setCharAt(newIndex--, str.charAt(oldIndex));
            }
            oldIndex--;
        }

        System.out.println(sb.toString());
        return;

    }

    public static void main(String[] args) {

        /**
         * 测试用例：
         * 1.空格在字符串中间："hello world"，result："hello%20world"。
         * 2.空格在字符串开头：" helloworld"，result："%20helloworld"。
         * 3.空格在字符串末尾："helloworld "，result："helloworld%20"。
         * 4.连续有两个空格："hello  world"，result："hello%20%20world"。
         * 5.字符串为null：null，result：什么都不会输出。
         * 6.传入内容为空的字符串：""，result：""。
         * 7.传入内容为一个空格的字符串：" "，result："%20"。
         * 8.传入的字符串没有空格："helloworld"，result："helloworld"。
         * 9.传入的字符串全是空格："   "，result："%20%20%20"。
         */

        replaceBlank1("m  d ");
    }
}
