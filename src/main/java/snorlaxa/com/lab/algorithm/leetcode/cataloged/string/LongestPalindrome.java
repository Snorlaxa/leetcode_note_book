package snorlaxa.com.lab.algorithm.leetcode.cataloged.string;

/**
 * @Author: Yzy
 * @Date: 2021/1/18 10:13
 * @题意: 求最长回文子串
 * @题解: 暴力遍历->动态规划->Manacher
 * 回文的形式如：abccba|abccbe
 */
public class LongestPalindrome {
    /**
     * 动态规划
     * f(i,j) = { f(i+1,j-1) if s[i]==s[j] }
     * or { 0 if s[i]!=s[j] }
     * or { 1 if j-i<=2 and s[i]==s[j] }
     * 动态规划起始点的选择【注意观察特殊情况的特点】：由于特殊情况是i==j，且此时i和j的值不确定，我们如果要从特殊情况开始遍历，相当于从i与j的距离为0时开始遍历，
     * 可以总结一下，这种不断向中间某个未知位置聚集的动态规划问题，如果特殊情况是i==j，可以转化为遍历距离的方式来确定起始点
     * @param str
     * @return
     */
    public static String solution01(String str) {
        int n = str.length();
        int[][] resultFlags = new int[n][n];
        String res = "";
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0; i < n - gap; i++) {
                // i和i+gap组成边界
                int j = i + gap;
                // i==j => str[i] = str[j] true "a"
                // j-i==1 and str[i]=str[j] true "aba"||"aa"
                if (str.charAt(i) == str.charAt(j) && (j - i <= 2 || resultFlags[i + 1][j - 1] == 1)) {
                    resultFlags[i][j] = 1;
                    if (gap + 1 > res.length()) {
                        res = str.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    /**
     * Manacher算法
     * TODO 暂未开发
     * @param str
     * @return
     */
    public static String solution02(String str) {
        // 插入#
        String src = "#" + String.join("#", str.split("")) + "#";

        return null;
    }

    public static void main(String[] args) {
        String str = "ffaffagg";
        String res = solution01(str);
        System.out.println(res);
    }
}
