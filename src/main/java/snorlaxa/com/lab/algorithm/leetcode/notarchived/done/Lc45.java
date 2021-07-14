package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/9 17:44
 * @题意: 跳跃游戏2，跳到最后一个数的最小次数
 * <p>按照跳跃游戏的方法，选出可以跳到最远地方的路线，每次跳到最远，则最后方案用的次数最少</p>
 * <p>实现的思路： 找从i位置跳一次的最优解。如[2,1,1,3,4,1]，从位置0最远可以跳到2，则需要看看[0,2]区间里是否有可以跳得更远的方法。
 * 只有遍历到位置2时，才可以知道有没有，且跳到这个最远的位置。下一步的位置也是如此。</p>
 */
public class Lc45 {
    public static int solution(int[] nums) {
        if (nums.length == 1) return 0;
        int count = 0, maxi = nums[0], end = 0;
        for (int i = 0; i < nums.length; i++) {
            maxi = Math.max(i + nums[i], maxi);
            // 到达最后位置
            if (maxi >= nums.length - 1) return ++count;
            // end 表示从i跳一次可以到达的最大位置
            // 当到达最远位置时，能够找到从i跳一次的最优解
            if (i == end) {
                count++;
                end = maxi;
            }
        }
        return count;
    }

    public static int solution2(int[] nums) {
        if (nums.length == 1) return 0;
        int step = 1;
        int next = 0;
        while ((next = findnext(nums, next)) < nums.length - 1) step++;
        return step;
    }

    private static int findnext(int[] nums, int current) {
        if (nums[current] + current >= nums.length - 1) return nums.length - 1;
        int next = current;
        for (int i = current; i <= nums[current] + current; i++) {
            if (i + nums[i] > next + nums[next]) {
                next = i;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1};
        System.out.println(solution2(nums));
    }
}
