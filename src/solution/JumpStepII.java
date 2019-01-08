package solution;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class JumpStepII {


    // 因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
    // 跳1级，剩下n-1级，则剩下跳法是f(n-1)
    // 跳2级，剩下n-2级，则剩下跳法是f(n-2)
    // 所以f(n)=f(n-1)+f(n-2)+...+f(1)
    // 因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
    // 所以f(n)=2*f(n-1)
    // 或者说:每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以不用考虑最后一个台阶，即共有2^(n-1)种情况
    public int jumpStepII(int n) {

//        if (n <= 0) {
//            return -1;
//        }
//
//        if (n == 1) {
//            return 1;
//        } else {
//            return 2 * jumpStepII(n - 1);
//        }

        if (n <= 0) {
            return -1;
        }
        return 1 << (n - 1);
    }
}
