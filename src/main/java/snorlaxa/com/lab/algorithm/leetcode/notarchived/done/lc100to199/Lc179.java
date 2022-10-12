package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

import java.util.Arrays;

/**
 * 给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 */
public class Lc179 {
    private static int[] a_nums = new int[22];
    private static int[] b_nums = new int[22];

    public static String solution(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        if (nums[0] == 0) return "0";
        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num);
        }
        return sb.toString();
    }

    private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int l = left - 1, r = right + 1, x = nums[left + right >> 1];
        while (l < r) {
            do l++; while (compare(nums[l], x));
            do r--; while (compare(x, nums[r]));
            // swap
            if (l < r) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
        }
        // div
        quickSort(nums, left, r);
        quickSort(nums, r + 1, right);
    }

    /**
     * 比较a、b的顺序
     *
     * @param a 第一个数
     * @param b 第二个数
     * @return True表示a排在b的前面
     */
    private static boolean compare(int a, int b) {
        if (a == b) return false;
        if (a == 0 || b == 0) return a > b;
        int ia = 0, ib = 0;
        while (a > 0 || b > 0) {
            if (a > 0) {
                a_nums[ia++] = a % 10;
                a = a / 10;
            }
            if (b > 0) {
                b_nums[ib++] = b % 10;
                b = b / 10;
            }
        }
        System.arraycopy(a_nums, 0, b_nums, ib, ia); // 倒着存，所以拼接后是反过来的，实际上是b+a
        System.arraycopy(b_nums, 0, a_nums, ia, ib); // a+b
        // 倒着取
        int j = ia + ib - 1, i = j;
        while (i >= 0 && j >= 0) {
            if (a_nums[i] != b_nums[j]) return a_nums[i] < b_nums[j];// 发现a+b比b+a的数据大
            i--;
            j--;
        }
        return false;
    }

    public String largestNumber(int[] nums) {
        Integer inums[] = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            inums[i] = nums[i];
        }
        Arrays.sort(inums, (x, y) -> {
            int sx = 10, sy = 10;
            while (sx <= x)
                sx *= 10;
            while (sy <= y)
                sy *= 10;
            return (sx * y + x - sy * x - y);
        });
        if (inums[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : inums) {
            ret.append(num);

        }
        return ret.toString();
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{8308, 830}; //83088308830
//        int[] nums = new int[]{3, 30, 34, 5, 9}; //83088308830
        int[] nums = new int[]{1, 0, 0};
        System.out.println(solution(nums));
    }
}
