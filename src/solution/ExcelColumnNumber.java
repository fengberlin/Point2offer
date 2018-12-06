package solution;

/**
 * 题目：Leetcode 171：Excel Sheet Column Number
 * 题目描述：给定一个在 Excel 表格中出现的列标题，请返回此列标题对应的列号。
 * 即在Excel中，用A表示第一列，B表示第二列...Z表示第26列，AA表示第27列，AB表示第28列,
 * BA表示第53列，BB表示第四列...
 * 由此我们可以看出，其本质是把十进制数字用A-Z表示成二十六进制，也就是说，其每个位上的表示 A ~ Z 正好对应了数字 1 ~ 26。
 */
public class ExcelColumnNumber {

    // 在这里我们只要把每个位的字母所表示的十进制数字拿出来，
    // 再与所在位的26的权值相乘，最后加起来即可。（也就是说像二进制转为十进制那样）
    // 那怎么去把字母表示的十进制拿出来呢？我们知道大写字母 A ~ Z 的 ASCII 码是相邻的，
    // 也就是说我们通过当前字母减去 ‘A’ 的码值就能得知当前字母相对于 ‘A’ 的位置，
    // 即可推算当前字母的值（最后要加上1，因为计算的是距离，我们要的是相对位置值）
    public static int excelColNum(String str) {

        if (str == null || str.length() == 0) {
            return 0;
        }

        int result = 0;
        // 从右边开始取字母值
        for (int i = 0; i < str.length(); i++) {
            int bitNum = str.charAt(str.length() - i - 1) - 'A' + 1;
            result += (int)(bitNum * Math.pow(26, i));
        }
        return result;
    }

    public static void main(String[] args) {

        int result = excelColNum("BB");
        System.out.println(result);
    }
}
