package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc1000plus;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Yzy
 * @version 1.0
 * Date: 2023/10/23 18:20
 * 题目：餐馆过滤器
 * 按条件过滤，返回餐馆的id，按照rating从高到低排，相同则按id排
 */
public class Lc1333 {
    public static List<Integer> solution(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        // 先按照rating排一遍？
        // 过滤，视为阈值：vegan一列是要求大于等于该阈值，其他列是要求小于等于该阈值
        // 先过滤，再排序？
        // 先排序再过滤，或者在过滤的过程中进行排序？或者在排序的过程中进行过滤
        // 对特定id下的数据进行排序？
        // 快排？把不符合条件的直接rating认为最小，然后从上到下遍历直到遇到第一个不符合条件的
        int[] ids = new int[restaurants.length];
        int j = -1;
        for (int i = 0; i < restaurants.length; i++)
            if (restaurants[i][2] >= veganFriendly && restaurants[i][3] <= maxPrice && restaurants[i][4] <= maxDistance)
                ids[++j] = i;
        quickSort(restaurants, ids, 0, j);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= j; i++) {
            res.add(restaurants[ids[i]][0]);
        }
        return res;
    }

    private static void quickSort(int[][] restaurants, int[] ids, int left, int right) {
        if (left >= right) return;

        // 分界点
        int idx = ids[left + right >> 1];
        int[] x = restaurants[idx];
        int i = left - 1, j = right + 1;
        while (i < j) {
            //找左边大于x的第一个元素和右边小于x的第一个元素交换
            do {
                i++;
            } while ((restaurants[ids[i]][1] > x[1]) || (restaurants[ids[i]][1] == x[1] && restaurants[ids[i]][0] > x[0]));
            do {
                j--;
            } while ((restaurants[ids[j]][1] < x[1]) || (restaurants[ids[j]][1] == x[1] && restaurants[ids[j]][0] < x[0]));
            // swap
            if (i < j) {
                int[] temp = restaurants[ids[j]];
                restaurants[ids[j]] = restaurants[ids[i]];
                restaurants[ids[i]] = temp;
            }
        }
        quickSort(restaurants, ids, left, j);
        quickSort(restaurants, ids, j + 1, right);
    }

    public static void main(String[] args) {
        int[][] restaurants = new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}};
//        int[][] restaurants = new int[][]{{49707, 71779, 1, 90061, 70036}, {63505, 69799, 0, 8562, 95089}, {5296, 11100, 0, 22243, 21831}};
//        System.out.println(solution(restaurants, 0, 35129, 99499));
        System.out.println(solution(restaurants, 1, 50, 10));
    }
}
