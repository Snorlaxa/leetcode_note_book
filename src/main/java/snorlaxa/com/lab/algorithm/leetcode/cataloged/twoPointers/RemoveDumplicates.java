package snorlaxa.com.lab.algorithm.leetcode.cataloged.twoPointers;

/**
 * @Author: Yzy
 * @Date: 2021/3/15 9:15
 * @题意: 删除排序数组中的重复项，只能使用O(1)空间
 * @题解: 从前向后数，跳过重复的，把重复项后面的数放到重复项第二个位置
 */
public class RemoveDumplicates {
    public static int solution(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                // swap
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
