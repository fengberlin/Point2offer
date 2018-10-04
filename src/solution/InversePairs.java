package solution;

/**
 * 面试题51：数组中的逆序对
 * 题目：在数组中的两个数字如果前面一个数字大于后面的数字，则这两个数字组
 * 成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 */
public class InversePairs {

    public int getInversePairsAmount(int[] data) {

        if (data == null || data.length == 0) {
            return 0;
        }

        int[] copy = new int[data.length];

        int count = getInversePairsAmountCore(data, copy, 0, data.length - 1);
        return count;
    }

    public int getInversePairsAmountCore(int[] data, int[] copy, int low, int high) {

        // 当子数组只有一个元素的时候
        if (low == high) {
            copy[low] = data[low];
            return 0;
        }

        int mid = (low + high) >> 1;
        // 牛客上要求
//        int leftCount = getInversePairsAmountCore(data, copy, low, mid) % 1000000007;
//        int rightCount = getInversePairsAmountCore(data, copy, mid + 1, high) % 1000000007;
        int leftCount = getInversePairsAmountCore(data, copy, low, mid);
        int rightCount = getInversePairsAmountCore(data, copy, mid + 1, high);
        int count = 0;
        int i = mid, j = high;    // 初始化时i、j指针分别指向第一个和第二个子数组的末尾
        int indexCopy = high;    // indexCopy指针指向copy数组的末尾
        while (i >= low && j > mid) {
            if (data[i] > data[j]) {
                // 因为在子数组中，data[j]大于它前面所有的元素，
                // 所以当data[i] > data[j]时，a[i]也是大于
                // data[j]和它前面所有的元素，所以逆序对的对数
                // 要加上前面所有的元素个数之和
                count += j - mid;
                // 然后把较大的元素copy到copy数组的末尾
                copy[indexCopy--] = data[i--];
//                if (count >= 1000000007) {
//                    count = count % 1000000007;
//                }
            } else {
                copy[indexCopy--] = data[j--];
            }
        }

        for (; i >= low; i--) {
            copy[indexCopy--] = data[i];
        }

        for (; j > mid; j--) {
            copy[indexCopy--] = data[j];
        }

        for (int k = low; k <= high; k++) {
            data[k] = copy[k];
        }

//        return (leftCount + rightCount + count) % 1000000007;    // 牛客上要求
        return (leftCount + rightCount + count);
    }
}
