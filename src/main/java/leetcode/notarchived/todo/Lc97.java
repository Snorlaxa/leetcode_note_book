package leetcode.notarchived.todo;

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
         */
        return dfs(s1, s2, s3, 0, 0, 0);
    }

    private static boolean dfs(String s1, String s2, String s3, int id1, int id2, int id3) {
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
                    return dfs(s1, s2, s3, id1 + 1, id2, id3 + 1)
                            || dfs(s1, s2, s3, id1, id2 + 1, id3 + 1);
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

    public static void main(String[] args) {
        boolean solution = solution("aabcc", "dbbca", "aadbbcbcac");
        System.out.println(solution);
    }
}
