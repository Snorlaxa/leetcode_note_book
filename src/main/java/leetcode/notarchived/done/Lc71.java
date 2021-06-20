package leetcode.notarchived.done;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Author: Yzy
 * @Date: 2021/6/20 23:48
 * @题目: 简化路径，给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径。
 * "."表示自身，“..”表示父节点，”...“表示文件名，”//" = “/"
 * 最后一个目录名（如果存在）不能 以 '/' 结尾
 * @题解: 明显可以采用队列的方式，但不应该采用char级别的操作，使用split后的字符串数组即可
 */
public class Lc71 {
    public static String solution(String path) {
        Deque<Character> queue = new ArrayDeque<>();
        char[] chars = path.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '/' && queue.size() > 0 && (queue.getLast() == '/' || i + 1 >= chars.length)) {
                // 如果之前就有/或者在末尾,跳过
                continue;
            }
            if (chars[i] == '.') {
                char c = queue.getLast();
                queue.add(chars[i]);
                if (c != '/') continue;
                int count = 1;
                while (i + 1 < chars.length && chars[i + 1] == '.') {
                    queue.add(chars[i++]);
                    count++;
                }
                if (i + 1 < chars.length && chars[i + 1] != '/') continue;
                if (count == 1) {
                    queue.removeLast();
                } else if (count == 2) {
                    // 删除 /..
                    while (!queue.isEmpty() && queue.getLast() != '/') queue.removeLast();
                    if (queue.size() > 1) queue.removeLast();
                    // 删除父级别
                    while (!queue.isEmpty() && queue.getLast() != '/') queue.removeLast();
                    if (queue.size() > 1) queue.removeLast();
                }
            } else {
                queue.add(chars[i]);
            }
        }
        if (queue.size() > 1 && queue.getLast() == '/') queue.removeLast();
        StringBuilder res = new StringBuilder();
        queue.forEach(res::append);
        return res.toString();
    }

    public static String solution2(String path) {
        Deque<String> queue = new ArrayDeque<>();
        String[] splits = path.split("/");
        for (String split : splits) {
            if (split.equals(".") || split.equals("")) continue;

            if (split.equals("..")) {
                if (!queue.isEmpty()) queue.pollLast();
            } else queue.offer(split);
        }
        StringBuilder res = new StringBuilder();
        res.append("/");
        while (!queue.isEmpty()) {
            res.append(queue.poll());
            if (!queue.isEmpty()) res.append("/");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution2("/a/./b/../.../c/"));
    }
}
