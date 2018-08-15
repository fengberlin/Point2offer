package solution;

/**
 * Problem 11：旋转数组的最小数字
 * 题目描述：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如数组
 * {3, 4, 5, 1, 2}为{1, 2, 3, 4, 5}的一个旋转，该数组的最小值为1。
 */
public class RotatedArray {

    // 这到题，我们主要用到的时二分查找的思想。因为只是把一部分的元素放到数组的末尾，
    // 所以此时数组会被分为两个有序的部分，而且前面部分的元素会大于或等于后面部分的元素。
    // 开始时用指针p1指向第一个元素，p2指向最后一个元素。pMid指向p1和p2所处区间的中间的数。
    // 基于这个大小的关系即两部分的数组都是有序的，我们可以每次用中间的数与指向p1的数和p2的数做比较。
    // 如果中间的数大于等于p1指向的数，则把p1的位置移动到中间的数所处的位置。
    // 如果中间的数小于等于p2指向的数，则把p2的位置移动到中间的数所处的位置。
    public static int minNumInRotatedArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("参数错误。");
        }

        int p1 = 0;
        int p2 = arr.length - 1;
        int pMid = p1;    // 这里设置为p1的值时为了旋转后的数组依然有序的情况（也即把0个元素放到数组的末尾）
        while (arr[p1] >= arr[p2]) {
            if (p2 - p1 == 1) {
                pMid = p2;
                break;
            }

            pMid = (p1 + p2) >>> 1;    // 到这里才计算指向中间元素的指针的位置

            // 如果下标为p1、p2和pMid指向的3个数字相等，则只能顺序查找，
            // 因为你不知道pMid指向的数字处于前面的子数组还是后面的子数组。
            // 例如{1, 0, 1, 1, 1}和{1, 1, 1, 0, 1}都可以看作递增排序数组{0, 1, 1, 1, 1}的旋转数组。
            // 对于这两种情况，我们是无法判断的。所以只好用顺序查找。
            if (arr[p1] == arr[p2] && arr[p1] == arr[pMid]) {
                return minInSequentialSearch(arr, p1, p2);
            }

            // 下面就是用到二分的思想了。
            if (arr[pMid] >= arr[p1]) {
                p1 = pMid;
            } else if (arr[pMid] <= arr[p2]) {
                p2 = pMid;
            }
        }

        return arr[pMid];
    }

    public static int minInSequentialSearch(int[] arr, int p1, int p2) {
        int min = arr[p1];

        for (int i = p1 + 1; i <= p2; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        return min;
    }


    /**
     * 采用二分法解答这个问题，
     * mid = low + (high - low)/2
     * 需要考虑三种情况：
     * (1)array[mid] > array[high]:
     * 出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
     * low = mid + 1
     * (2)array[mid] == array[high]:
     * 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边
     * 还是右边,这时只好一个一个试 ，
     * high = high - 1
     * (3)array[mid] < array[high]:
     * 出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左
     * 边。因为右边必然都是递增的。
     * high = mid
     * 注意这里有个坑：如果待查询的范围最后只剩两个数，那么mid 一定会指向下标靠前的数字
     * 比如 array = [4,6]
     * array[low] = 4 ;array[mid] = 4 ; array[high] = 6 ;
     * 如果high = mid - 1，就会产生错误， 因此high = mid
     * 但情形(1)中low = mid + 1就不会错误
     */
    public static int minNumInRotatedArray0(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while (low < high) {
            mid = (high + low) >>> 1;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else if (arr[mid] == arr[high]) {
                high = high - 1;
            } else {
                high = mid;
            }
        }

        return arr[low];
    }
}
