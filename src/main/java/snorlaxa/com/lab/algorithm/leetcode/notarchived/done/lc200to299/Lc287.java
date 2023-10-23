package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc200to299;

/**
 * @author Yzy
 * @version 1.0
 * Date: 2023/9/27 13:34
 */
public class Lc287 {
    /**
     * 快慢指针法
     * 参考寻找环的入口
     * [1,2,3,4,3,5]
     *
     * @param nums 数组
     * @return 重复数
     */
    public static int solution(int[] nums) {
        int fast = 0, slow = 0;
        while (slow == 0 || fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return fast;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 4, 4, 3};
        System.out.println(solution(nums));
    }
}
