package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc0to99;

/**
 * @Author: 余子毅
 * @Date: 2021/6/22 16:09
 * @题意: 颜色分类。[1, 1, 0, 1, 2, 0, 0, 1] 排序成[0,0,1,1,1,2,2]，不使用java排序
 * @题解: 模拟快排的分区过程，使得左边的数都小于1，右边的数都大于1
 * 思路确定后，重要的是维护区间边界的定义。首先定义zero为结果的0开边界，定义two为结果的2的闭区间边界。在遍历时，如果遇到0，应该放在zero的左边，
 * 2应该放在two的位置，1则不改变位置。
 * 如定义zero时，zero指向的位置一直是下一个0要填入的位置，遇到0时即可交换到该位置。
 * 定义two时也是如此，two指向的是下一个2应该填入的位置，所以在执行时必须先减去
 *
 * 类似于三色棋子的排序，白红蓝分别应放在第一二三阶段，遇到白棋就需要与一阶段的前一个棋子交换位置，遇到蓝棋就与第三阶段的后一个交换位置。
 */
public class Lc75 {
    public static void solution(int[] nums) {
        int l = 0, zero = 0, two = nums.length;
        while (l < two) {
            if (nums[l] == 0) {
                swap(nums, zero, l);
                l++;
                zero++;
            } else if (nums[l] == 1) {
                l++;
            } else if (nums[l] == 2) {
                two--;
                swap(nums, l, two);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 1' 1 0 0 0 2 2 0 1
     * 0 1' 1 0 0 2 2 0 1
     * 0 0 1' 1 0 2 2 0 1
     * 0 0 1' 1 0 2 2 0 1
     * 0 0 0 1' 1 2 2 0 1
     */
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 0, 2, 2, 0, 1};
        solution(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}