package leetcode.notarchived.todo;

/**
 * @Author: 余子毅
 * @Date: 2021/5/12 9:32
 * @题意: 在旋转数组中查找目标值，要求时间复杂度O(logn)。旋转数组指的是从随机的某位置开始，把该位置之前的数据全部移到数组末尾。如：[1,2,3,4,5,6] => [3,4,5,6,7,0,1,2]
 * @题解:
 */
public class Lc33 {
    public static int solution(int[] nums, int x) {
        int l = 0, r = nums.length - 1;
        int last = nums[nums.length - 1];
        int start = nums[0];
        while (l < r) {
            int mid = l + r >> 1;
//            if (start <= x) {
//                if (nums[mid] < x && nums[mid] > start) {
//                    l = mid + 1;
//                } else {
//                    r = mid - 1;
//                }
//            } else {
//                if (nums[mid] > x && nums[mid] < start) {
//                    r = mid - 1;
//                } else {
//                    l = mid + 1;
//                }
//            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(solution(nums, 3));
    }
}
