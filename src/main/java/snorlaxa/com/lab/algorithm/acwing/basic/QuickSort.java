package snorlaxa.com.lab.algorithm.acwing.basic;


/**
 * @Author: 余子毅
 * @Date: 2021/5/24 9:47
 */
public class QuickSort {
    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int x = nums[left + right >> 1], i = left - 1, j = right + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            // swap
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 31, 3, 1, 5, 5, 4, 6};
        quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
