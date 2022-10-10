package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc0to99;

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
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxi) {
                maxi = Math.max(i + nums[i], maxi);
                if (maxi >= nums.length-1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 0, 1, 3, 0, 1};
        boolean solution = solution(nums);
        System.out.println(solution ? '是' : '否');
    }
}
