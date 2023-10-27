package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

import java.util.*;

/**
 * @author Yzy
 * @version 1.0
 * Date: 2023/10/25 13:38
 * 164. 最大间距
 * 给定一个无序的数组 nums，返回 数组在排序之后，相邻元素之间最大的差值 。如果数组元素个数小于 2，则返回 0 。
 * <p>
 * 您必须编写一个在「线性时间」内运行并使用「线性额外空间」的算法。
 */
public class Lc164 {
    /**
     * 桶排序
     * 希望能只计算桶间的，不用计算桶内的，只要保证有一个空桶就可以确定桶内部一定不会有最大间隔。
     * 如何保证有一个空桶：把n个数值放入n-1个桶中就一定会有空桶，所以设计的间隔为(max-min)/(n-1)
     *
     * @param nums 数组
     * @return 最大差额
     */
    public static int solution(int[] nums) {
        if (nums.length < 2) return 0;

        int max = -1, min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int interval = (int) Math.ceil((double) (max - min) / (nums.length - 1)); // 让n-2个数字放入n-1个桶，就能保证一定有一个空桶

        if (interval == 0) return 0;

        int[] bucket_min = new int[nums.length]; // 为了防止向上取整可能导致的越界，多用1个桶
        int[] bucket_max = new int[nums.length];
        Arrays.fill(bucket_min, Integer.MAX_VALUE);
        Arrays.fill(bucket_max, -1);

        for (int num : nums) {
            int index = (num - min) / interval;
            bucket_min[index] = Math.min(bucket_min[index], num);
            bucket_max[index] = Math.max(bucket_max[index], num);
        }

        int last_max = bucket_max[0], max_interval = -1;
        for (int i = 1; i < bucket_min.length; i++) {
            if (bucket_max[i] == -1) continue;
            int bucket_interval = bucket_min[i] - last_max;
            max_interval = Math.max(bucket_interval, max_interval);
            last_max = bucket_max[i];
        }
        return max_interval;
    }

    /**
     * 基数排序
     *
     * @param nums 数组
     * @return 最大差额
     */
    public static int solution2(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;

        int max = Arrays.stream(nums).max().getAsInt();

        // 基数排序
        // 1. 从1不断增长位数，直到超过最大值
        long dim = 1;
        // 临时排序存储
        int[] temp = new int[n];
        while (max >= dim) {
            // 取当前位的数据做计数排序
            int[] cnt = new int[10];
            for (int num : nums) {
                int idx = (num / (int) dim) % 10;
                cnt[idx]++;
            }
            for (int i = 1; i < cnt.length; i++) {
                cnt[i] += cnt[i - 1];
            }
            // 根据数值前面的个数确定了位置，对数组按顺序进行复制
            // 倒着处理，后出现的数字对应了cnt数组中的数字，减少cnt的过程也是向前移动的过程
            for (int i = n - 1; i >= 0; i--) {
                int idx = (nums[i] / (int) dim) % 10;
                temp[cnt[idx] - 1] = nums[i];
                cnt[idx]--; // 重复数字，往前排
            }
            System.arraycopy(temp, 0, nums, 0, n);

            dim *= 10;
        }
        int result = 0, last = nums[0];
        for (int num : nums) {
            result = Math.max(result, num - last);
            last = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{15252, 16764, 27963, 7817, 26155, 20757, 3478, 22602, 20404, 6739, 16790, 10588, 16521, 6644, 20880, 15632, 27078, 25463, 20124, 15728, 30042, 16604, 17223, 4388, 23646, 32683, 23688, 12439, 30630, 3895, 7926, 22101, 32406, 21540, 31799, 3768, 26679, 21799, 23740};
        System.out.println(solution2(nums));
    }
}
