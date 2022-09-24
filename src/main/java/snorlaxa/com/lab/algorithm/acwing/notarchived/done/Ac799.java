package snorlaxa.com.lab.algorithm.acwing.notarchived.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ac799 {
    private static final int[] S = new int[100010];

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(in);
        int n = Integer.parseInt(bufferedReader.readLine());
        String line = bufferedReader.readLine();
        int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(longestNoRepeat(nums, n));


    }

    /**
     * 求最长连续不重复子串的长度
     * 要求：子串没有重复数字即可
     * 双指针
     *
     * @param nums 数组
     * @return 最长连续不重复子串的长度
     */
    private static int longestNoRepeat(int[] nums, int n) {
        int res = 0;
        for (int i = 0, j = 0; i < n; i++) {
            S[nums[i]]++;
            //当新增i的时候，重复的数字只有可能是新加入的nums[i]
            // j<=i没有意义，因为当j>i事，nums[i]==0,nums[j]==0
            while (S[nums[i]] > 1) {
                S[nums[j]]--; // 往前移动直到没有重复
                j++;
            }
            res = Math.max(res, i - j + 1);
        }

        return res;
    }

    /**
     * 双指针模板
     *
     * @param nums
     * @return
     */
    private static int doubleIndex(int[] nums) {
        int res = 0;
        for (int i = 0, j = 0; i < nums.length; i++) {
            while (S[nums[i]] > 1 && check(i, j)) j++;//检查当前的j是否满足条件，不满足的话就一直往前移动直到满足
            res = Math.max(res, i - j + 1);
        }

        return res;
    }

    private static boolean check(int i, int j) {
        return true;
    }
}
