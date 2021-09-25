package snorlaxa.com.lab.algorithm.base;

import java.util.*;

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
     * 邻接矩阵生成图，节点下标就是节点的值
     *
     * @param matrix 邻接矩阵
     */
    public static Node fromMatrix(int[][] matrix) {
        int n = matrix.length;
        if (n <= 0) return null;

        Map<Integer, Node> nodeHashMap = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            // 节点序号
            // 创建节点
            Node node = new Node(i, new ArrayList<>());
            nodeHashMap.putIfAbsent(i, node);
            for (int next : matrix[i - 1]) {
                if (nodeHashMap.containsKey(next)) {
                    node.neighbors.add(nodeHashMap.get(next));
                } else {
                    Node nextNode = new Node(next, new ArrayList<>());
                    nodeHashMap.put(next, nextNode);
                }
            }
        }
        return nodeHashMap.get(1);
    }
}
