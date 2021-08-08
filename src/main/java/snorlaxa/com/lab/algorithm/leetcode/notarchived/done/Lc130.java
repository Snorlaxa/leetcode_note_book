package snorlaxa.com.lab.algorithm.leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/8/4 9:57
 * @题意: 被围绕的区域。只有被x完全包围的区域才需要替换成x，如果连通区域连接到边界，就不能替换
 */
public class Lc130 {
    public static void solution(char[][] board) {
        /**
         * 从四个边界开始查找与边界相连的连通区域，采用dfs
         *
         */
        int r = board.length, c = board[0].length;
        // 上下
        for (int i = 0; i < c; i++) {
            // 标记不可修改的连通区域
            dfs(board, 0, i);
            dfs(board, r - 1, i);
        }

        // 左右
        for (int i = 0; i < r; i++) {
            dfs(board, i, 0);
            dfs(board, i, c - 1);
        }
        // 修改矩阵
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'K') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void dfs(char[][] board, int i, int j) {
        /**
         * 与边界联通的区域
         */
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O') return;
        board[i][j] = 'K';
        // 上
        dfs(board, i - 1, j);
        // 下
        dfs(board, i + 1, j);
        // 左
        dfs(board, i, j - 1);
        // 右
        dfs(board, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solution(board);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}
