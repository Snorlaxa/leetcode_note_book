package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc100to199;

import snorlaxa.com.lab.algorithm.base.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 余子毅
 * @Date: 2021/9/17 16:14
 * @题意: 克隆图。对一张图做深度拷贝
 */
public class Lc133 {
    public static Node solution(Node node) {
        if (node == null) return null;
        return dfs(node, new HashMap<>());
    }

    public static Node dfs(Node node, Map<Node, Node> map) {
        if (map.containsKey(node)) return map.get(node);
        ArrayList<Node> neighbors = new ArrayList<>();
        Node clone = new Node(node.val, neighbors);
        map.put(node, clone);
        // 遍历相邻节点，克隆并链接
        for (Node next : node.neighbors) {
            clone.neighbors.add(dfs(next, map));
        }
        return clone;
    }
}
