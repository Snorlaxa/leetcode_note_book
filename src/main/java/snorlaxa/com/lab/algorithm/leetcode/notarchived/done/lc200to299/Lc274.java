package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc200to299;

import java.util.Arrays;

/**
 * @Author: Yzy
 * @Date: 2021/7/11 10:23
 * @题意: H 指数。h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的N - h篇论文每篇被引用次数不超过 h 次。
 */
public class Lc274 {
    public static int solution(int[] citations) {
        /**
         * [3,0,6,1,5]
         * 排序：
         * [0,1,3,5,6]
         * 至少3的文章有5-2=3篇
         * 至少0的文章有5-0=5篇
         * 至少6的文章有5-4=1篇
         */
        Arrays.sort(citations);
        int max = 0;
        for (int i = 0; i < citations.length; i++) {
            int count = citations.length - i;
            if (max < count) {
                // max记录的count不能超过nums[i]
                max = count % (citations[i] + 1);
            }
        }
        return max;
    }

    public static int solution2(int[] citations) {
        Arrays.sort(citations);
        int h = 0, i = citations.length - 1;
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 6, 1, 4, 4, 5, 5, 5, 5};
        int solution = solution2(nums);
        System.out.println(solution);

    }
}
