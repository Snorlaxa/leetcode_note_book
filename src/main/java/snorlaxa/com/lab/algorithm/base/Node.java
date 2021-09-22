package snorlaxa.com.lab.algorithm.base;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 余子毅
 * @Date: 2021/9/17 16:15
 * 连通图节点
 */
public class Node {
    public int val;
    public List<Node> neighbors;

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }

    /**
     * TODO 从值数组和邻接矩阵生成图，随机返回一个节点
     *
     * @param matrix 邻接矩阵
     */
    public static Node fromMatrix(int[][] matrix) {
        int n = matrix.length;
        Set<Node> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            // 节点序号
            // 创建节点
            Node node = new Node(i, new ArrayList<>());
            for (int next : matrix[i - 1]) {

            }
        }
        return null;
    }
}
