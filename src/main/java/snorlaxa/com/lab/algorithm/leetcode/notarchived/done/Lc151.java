package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

public class Lc151 {

    public static String reverseWords(String s) {
        s = " " + s; // 停止标识
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1, j = n; i >= 0; i--) {
            if (s.charAt(i) != ' ') continue;
            if (i + 1 != j) {
                sb.append(s, i + 1, j).append(" ");
            }
            j = i;
        }
        return sb.substring(0, sb.length() - 1);
    }


    public static void main(String[] args) {
        String s = reverseWords("example ");
        System.out.println(s);
    }
}
