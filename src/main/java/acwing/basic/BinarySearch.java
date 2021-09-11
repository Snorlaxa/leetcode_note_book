package acwing.basic;

/**
 * @Author: 余子毅
 * @Date: 2021/5/24 9:41
 * 二分的本质是：目标值target应该是某个分界点，在分界点左边的数全部符合某种条件，分界点右边的数全部不符合某种条件
 */
public class BinarySearch {

    /**
     * 直接在循环能中找到结果
     *
     * @param target 目标值
     * @param nums   原始数组
     * @return 目标位置
     */
    public static int binarySearch(int target, int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /**
     * 在循环中不能直接判断出结果，并且取靠右的结果
     *
     * @param target 目标值
     * @param nums   原始数组
     * @return 目标位置
     */
    public static int binarySearch2(int target, int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            // 因为取left = mid，如果不+1可能会导致死循环，比如mid = 0+1>>1=0,left = mid = 0,left+right=0+1
            int mid = left + right + 1 >> 1;
            // mid在target右边，且mid不可能取到target
            if (nums[mid] > target)
                right = mid - 1;
            else
                left = mid;
        }
        // 取left作为结果，因为在mid符合目标条件的情况下，取left=mid，跳出后left就是符合目标条件的一个值
        return left;
    }


    /**
     * 在循环中不能直接判断出结果，并取靠左的结果
     *
     * @param target 目标值
     * @param nums   原始数组
     * @return 目标位置
     */
    public static int binarySearch3(int target, int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + right >> 1;
            // mid落在左边，且mid不可能取到target
            if (nums[mid] < target)
                left = mid + 1;
            else
                right = mid;
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3, 3, 4, 5, 6, 7, 7, 7};
        int res = binarySearch3(3, nums);
        System.out.println(res);
    }
}
