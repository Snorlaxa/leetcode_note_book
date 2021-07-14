package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/7/6 10:40
 * @题意: 交错字符串。判断s3是否为s1和s2交错形成。即字符相互交错但保持字符相互顺序
 */
public class Lc97 {
    public static boolean solution(String s1, String s2, String s3) {
        /**
         * a ad
         * aadbcb
         * 一个个匹配，当出现一个字符能匹配两个字符串时，两种可能性都试试
         * 此方法会导致复杂度过高。当存在大量可匹配两个字符串的字符时，搜索树会非常深，如“aaaaaa....aaaa"和“aaaaaa....aaaa"的组合
         * 需要剪枝
         */
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean[][] visited = new boolean[s1.length()][s2.length()];
        return dfs(s1, s2, s3, 0, 0, 0, visited);
    }

    // TODO 实现剪枝
    private static boolean dfs(String s1, String s2, String s3, int id1, int id2, int id3, boolean[][] visited) {
        while (id3 < s3.length() && (id1 < s1.length() || id2 < s2.length())) {
            char c3 = s3.charAt(id3);
            Character c1 = null, c2 = null;
            if (id1 < s1.length()) {
                c1 = s1.charAt(id1);
            }
            if (id2 < s2.length()) {
                c2 = s2.charAt(id2);
            }
            if (c1 != null && c3 == c1) {
                if (c2 != null && c3 == c2) {
                    return dfs(s1, s2, s3, id1 + 1, id2, id3 + 1, visited)
                            || dfs(s1, s2, s3, id1, id2 + 1, id3 + 1, visited);
                } else {
                    id1++;
                    id3++;
                }
            } else if (c2 != null && c3 == c2) {
                id2++;
                id3++;
            } else {
                return false;
            }
        }
        return id3 >= s3.length() && (id1 >= s1.length() && id2 >= s2.length());
    }

    /**
     * 方法2，动态规划
     *
     * @param s1 s1
     * @param s2 s2
     * @param s3 s3
     * @return boolean
     */
    public static boolean solution2(String s1, String s2, String s3) {
        /**
         * 长度为n的合并字符串，如果长度为n-1的字符串由i-1和j长度的字符串合并，则n是否为i和j合并取决于i的最后一个字符是否等于n的最后一个字符
         * f[i,j]= (f[i-1,j]&&match(i-1,j))
         *          ||(f[i,j-1]&&match(i,j-1));
         */
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        for (int j = 1; j <= s2.length(); j++) dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);

        for (int i = 1; i <= s1.length(); i++) {
            char c1 = s1.charAt(i - 1);
            for (int j = 1; j <= s2.length(); j++) {
                char c2 = s2.charAt(j - 1);
                char c3 = s3.charAt(i + j - 1);
                dp[i][j] = (dp[i - 1][j] && c1 == c3) || (dp[i][j - 1] && c2 == c3);
            }
        }
        return dp[s1.length()][s2.length()];
    }

    /**
     * 优化为O(n)空间复杂度
     *
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public static boolean solution3(String s1, String s2, String s3) {
        /**
         * 长度为n的合并字符串，如果长度为n-1的字符串由i-1和j长度的字符串合并，则n是否为i和j合并取决于i的最后一个字符是否等于n的最后一个字符
         * f[i,j]= (f[i-1,j]&&match(i-1,j))
         *          ||(f[i,j-1]&&match(i,j-1));
         */
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean[] dp = new boolean[s2.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                int ic3 = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s1.charAt(i - 1) == s3.charAt(ic3);
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(ic3));
                }
            }
        }
        return dp[s2.length()];
    }

    public static void main(String[] args) {
        boolean solution = solution3("abababababababababababababababababababababababababababababababababababababababababababababababababbb", "babababababababababababababababababababababababababababababababababababababababababababababababaaaba", "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb");
        System.out.println(solution);
    }
}