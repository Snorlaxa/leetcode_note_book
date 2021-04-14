package leetcode.cataloged.backtracing;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yzy
 * @Date: 2021/2/19 9:20
 * @题意: 生成n对括号，输出所有可能的有效组合（不存在不闭合括号表示有效），1<=n<=8
 * @题解: 采用回溯剪枝的方法，相当于二叉树dfs遍历，在遍历过程中去除一些不符合条件的情况
 * 遍历顺序是先序遍历
 */
public class GenerateParenthesis {
    public static List<String> solution(int n) {
        List<String> result = new ArrayList<>();
        recursion(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    private static void recursion(List<String> result, StringBuilder currentStr, int left, int right, int n) {
        // 终止条件：括号数量用尽
        if (left == n && right == n) {
            result.add(currentStr.toString());
            return;
        }

        // 优先左括号
        if (left < n) {
            recursion(result, currentStr.append("("), left + 1, right, n);
            currentStr.setLength(currentStr.length()-1);
        }

        // 到达左括号边界后
        // 剪枝条件：右括号多于左括号
        if (right < left) {
            recursion(result, currentStr.append(")"), left, right + 1, n);
            currentStr.setLength(currentStr.length()-1);
        }

    }

    public static void main(String[] args) {
        int n = 3;
        List<String> result = solution(n);
        result.forEach(System.out::println);
    }
}
