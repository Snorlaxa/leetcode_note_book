package leetcode.notarchived.done;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/5/7 10:15
 * @题意: 字母异位词分组
 * @题解: 不同异位词的相同点是排序后一致或者在hash数组上的位置一致，分组借用map来自动分组
 */
public class Lc49 {

    public static Collection<List<String>> solution(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();
        for (String s : strs) {
            // 构建不同异位词的共同点，组织成字符串
//            int[] rule = new int[26];
//            for (int i = 0; i < s.length(); i++) {
//                char c = s.charAt(i);
//                rule[c - 'a'] += 1;
//            }
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> list = res.getOrDefault(key, new ArrayList<>());
            list.add(s);
            res.put(key, list);
        }
        return new ArrayList<>(res.values());
    }

    public static void main(String[] args) {
        String[] strs = {"adc", "cda", "adcc", "cda", "jjasdkfa"};
        Collection<List<String>> solution = solution(strs);
        solution.forEach(x -> {
            x.forEach(c -> {
                System.out.print(c + " ");
            });
            System.out.println();
        });
    }

}
