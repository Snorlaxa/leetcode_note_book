package leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/7/2 9:49
 * @题意: 不同的二叉搜索树。 给一个整数n，返回所有n个节点组成的不同二叉搜索树的种类数量，节点值从1到n
 */
public class Lc96 {
    public static int solution(int n) {
        /**
         * 是否可以复用n-1的结果.
         * 即把问题变成给n-1个二叉树添加一个节点有多少方式。不可以，每增加一个节点的情况太多了。
         * 总共有n个节点，分别为1到n，如果1~k-1个节点作为左子树，k+1~n个节点作为右子树，结果就变成所有组合的左右子树的种类之乘积，
         * 而左右子树的乘积又等于所有组合的子子树之乘积，以此类推就可以复用之前的结果。
         * 与复用n-1的结果不同，此方法从子问题推导到父问题的结果是确定的，即确定位乘积。
         */

        // 当某一棵子树节点为0或1时，种类数为1
        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;

        // 确定节点数
        for (int i = 2; i <= n; i++) {
            // 遍历所有子树组合，注意左右子树的节点数是要减去一个根节点k的，所以到i-1
            for (int j = 0; j <= i - 1; j++) {
                res[i] += res[j] * res[i - j - 1];
            }
        }
        return res[n];
    }

    public static void main(String[] args) {
        int solution = solution(3);
        System.out.println(solution);
    }
}
