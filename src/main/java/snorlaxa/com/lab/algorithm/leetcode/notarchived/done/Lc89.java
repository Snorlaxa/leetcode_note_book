package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 余子毅
 * @Date: 2021/6/29 11:39
 * @题意: 格雷编码
 * 二进制序列的两个相邻二进制仅相差一位，序列必须以0开头。如00，10，01，11.返回总位数为n的格雷编码序列
 * 镜像构造
 */
public class Lc89 {
    public static List<Integer> solution(int n) {
        if (n == 0) return new ArrayList<>(Collections.singletonList(0));
        if (n == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(0);
            list.add(1);
            return list;
        }
        List<Integer> result = solution(n - 1);
        for (int i = result.size() - 1; i >= 0; i--) {
            Integer code = result.get(i);
            // 首个bit补1
            result.add(code | (1 << n - 1));
        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> solution = solution(4);
        for (Integer r : solution) {
            System.out.print(r + " ");
        }
    }
}
