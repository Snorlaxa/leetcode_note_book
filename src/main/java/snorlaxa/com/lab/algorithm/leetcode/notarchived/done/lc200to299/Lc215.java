package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc200to299;


/**
 * @author Yzy
 * @version 1.0
 * Date: 2023/10/24 13:45
 * 数组中的第k个最大元素
 * 要求时间复杂度为O(n)
 * 可能存在重复数字，重复数需要计入
 */
public class Lc215 {
    /**
     * 第k大元素
     * 快排的思路，快速搜索和哨兵，可以快速排除另一半空间
     *
     * @param nums 数组
     * @param k    k
     * @return 第k大元素值
     */
    public static int solution(int[] nums, int k) {
        return quickFind(nums, k, 0, nums.length - 1);
    }

    public static int quickFind(int[] nums, int k, int left, int right) {
        if (left >= right) return nums[right];
        // 先交换，再看右边的是否有k个
        int mid = left + right >> 1;
        int x = nums[mid];
        int i = left - 1, j = right + 1;
        while (i < j) {
            while (nums[++i] < x) ;
            while (nums[--j] > x) ;
            // swap
            if (i < j) { // 在循环中处理了检测条件，一定要重新检测一次
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        // 看右边有没有k个，没有就是在左边
        int rn = right - j;
        if (rn >= k) {
            return quickFind(nums, k, j + 1, right); // 在右边仍然是第k个
        } else {
            return quickFind(nums, k - rn, left, j);// 在左边被截断了右边的个数
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 3, 1, 3, 7, 6, 4};
        int[] testk = new int[]{1, 2, 3, 4, 5, 6};
        for (int k : testk) {
            System.out.println(solution(nums, k));
        }
    }
}
