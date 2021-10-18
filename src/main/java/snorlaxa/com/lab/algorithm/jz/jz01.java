package snorlaxa.com.lab.algorithm.jz;

/**
 * @Author: 余子毅
 * @Date: 2021/10/8 11:53
 * @题解: 二维数组，每一行从左到右递增，每一列从上到下递增，输入二维数组和整数，判断是否包含该整数，时间复杂度O(m+n)
 */
public class jz01 {
    public static boolean solution(int target, int[][] nums) {
        /**
         * 1 2 8 9
         * 2 4 8 12
         * 4 7 10 13
         * 6 8 11 15
         */
        // 查找可能的行、列
        int row = nums.length, col = nums[0].length;
        int i = 0, j = col - 1;
        while (i < row && j >= 0) {
            int val = nums[i][j];
            if (val < target)
                // 本行不可能存在target
                i++;
            else if (val > target)
                // 本列不可能存在target
                j--;
            else
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 8, 9}, {2, 4, 8, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean rs = solution(6, nums);
        System.out.println(rs);
    }
}
