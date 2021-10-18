package snorlaxa.com.lab.algorithm.acwing.basic;

/**
 * @Author: 余子毅
 * @Date: 2021/5/24 9:45
 */
public class MergeSort {
    private static int[] temp;

    public static void mergeSort(int[] nums) {
        temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + right >> 1;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        // merge
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        // 处理中断后的数据
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        // 赋值
        System.arraycopy(temp, left, nums, left, right + 1 - left);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 31, 3, 1, 5, 5, 4, 6};
        mergeSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
