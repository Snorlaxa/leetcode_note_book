package leetcode.notarchived.done;

/**
 * @Author: Yzy
 * @Date: 2021/4/15 10:33
 * @Title: Number of Islands 岛屿的数量
 * @题意: 给定2d网格图(其中 ， 1代表陆地 0代表水)，计算岛屿数量。 岛被水包围，通过水平或垂直连接相邻的土地而形成。求岛屿数量
 * @题解: O(n ^ 2)遍历，dfs查连通性，连通的数据修改为0，即已标记过的都去除
 */
public class Lc200 {
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // 从获取到的岛屿格子开始进行dfs标记为0
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    public void dfs(char[][] nums, int i, int j) {
        nums[i][j] = '0';
        //上
        if (i - 1 >= 0 && nums[i - 1][j] == '1') {
            dfs(nums, i - 1, j);
        }
        //下
        if (i + 1 < nums.length && nums[i + 1][j] == '1') {
            dfs(nums, i + 1, j);
        }
        //左
        if (j - 1 >= 0 && nums[i][j - 1] == '1') {
            dfs(nums, i, j - 1);
        }
        //右
        if (j + 1 < nums[0].length && nums[i][j + 1] == '1') {
            dfs(nums, i, j + 1);
        }
    }

    public static void main(String[] args) {
        char[][] nums = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
        int res = new Lc200().numIslands(nums);
        System.out.println(res);
    }
}
