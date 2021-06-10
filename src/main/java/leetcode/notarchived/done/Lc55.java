package leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/8 11:11
 * @题意: 跳跃游戏，判断是否能跳到最后一个
 * <p>>每次跳到最远的地方，比如[2,1,2,1]，从位置1开始，可以跳1步或者2步.
 * 如果选择跳1步，到达位置1，后续最多可以再跳1步，即2+1=3；
 * 如果选择跳2步，跳到位置2，则最多又可以跳2步，即2+2=4
 * 此时选择方案2，跳2步，以此类推</p>
 * <p>实现的思路： 找从i位置跳一次的最优解。如[2,1,1,3,4,1]，从位置0最远可以跳到2，则需要看看[0,2]区间里是否有可以跳得更远的方法。
 * 只有遍历到位置2时，才可以知道有没有，且跳到这个最远的位置。下一步的位置也是如此。</p>
 */
public class Lc55 {
    public static boolean solution(int[] nums) {
        // 从i可以到的最远位置
        int end = nums[0];
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            // 说明在上一次查找后，end==i==maxi，即最优解的最后一位等于0，如果能到达最后，最后一位应该至少等于1，即maxi=end+1；
            if (i > end) return false;
            maxi = Math.max(i + nums[i], maxi);
            if (maxi >= nums.length) return true;
            if (i == end) {
                end = maxi;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 0, 1, 3, 0, 1};
        boolean solution = solution(nums);
        System.out.println(solution ? '是' : '否');
    }
}
