package solution;

import java.util.*;

/**
 * 面试题61：扑克牌的顺子
 * 题目：从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王可以看成任意数字。
 */
public class ContinousCards {

    public boolean isContinous(int[] cards) {

        if (cards == null || cards.length != 5) {
            return false;
        }

        int numOfZero = 0;    // 0的个数
        int numOfInterval = 0;    // 排序后相邻数字间相差的间隔数
        Arrays.sort(cards);
        for (int i = 0; i < cards.length; i++) {
            // 计算癞子即0数量
            if (cards[i] == 0) {
                numOfZero++;
                continue;
            }

            // 有对子，直接返回false
            if ((i < cards.length - 1) && (cards[i] == cards[i + 1])) {
                return false;
            }

            if (i < cards.length - 1) {
                numOfInterval += cards[i + 1] - cards[i] - 1;
            }
        }

        if (numOfZero >= numOfInterval) {
            return true;
        }

        return false;
    }
}
