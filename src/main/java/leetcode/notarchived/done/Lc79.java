package leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/27 23:32
 * @题意: 单词搜索.给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false
 */
public class Lc79 {
    public static boolean solution(char[][] board, String word) {
        int row = board.length;
        if (row == 0 || word.length() == 0) return false;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, new int[row][col], word, i, j, 0)) return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(char[][] board, int[][] flags, String word, int r, int c, int current) {
        if (!inArea(r, c, board)) return false;
        if (flags[r][c] > 0) return false;
        if (current >= word.length()) return true;
        if (word.charAt(current) != board[r][c]) return false;

        // 上
        int r0 = r - 1;
        // 下
        int r1 = r + 1;
        // 左
        int c0 = c - 1;
        // 右
        int c1 = c + 1;

        flags[r][c] = 1;
        boolean res = dfs(board, flags, word, r0, c, current + 1)
                || dfs(board, flags, word, r1, c, current + 1)
                || dfs(board, flags, word, r, c0, current + 1)
                || dfs(board, flags, word, r, c1, current + 1);

        flags[r][c] = 0;
        return res;
    }

    private static boolean inArea(int x, int y, char[][] board) {
        return x >= 0 && y >= 0 && x < board.length && y < board[0].length;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        boolean solution = solution(board, word);
        System.out.println(solution ? '是' : '否');
    }
}
