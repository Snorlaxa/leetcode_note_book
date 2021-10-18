package snorlaxa.com.lab.algorithn;

import org.junit.Test;
import snorlaxa.com.lab.algorithm.base.Node;

import java.util.HashSet;
import java.util.Set;


/**
 * @Author: 余子毅
 * @Date: 2021/7/14 9:45
 */
public class NodeTest {
    @Test
    public void treeNodePrintTest() {
        int[][] nums = new int[][]{{2, 3}, {1, 3}, {1}};
        Node node = Node.fromMatrix(nums);
        Set<Integer> visited = new HashSet<>();
        dfs(node, visited);
    }

    private void dfs(Node node, Set<Integer> visited) {
        if (node == null || visited.contains(node.val)) return;
        System.out.println(node.val);
        visited.add(node.val);
        for (Node n : node.neighbors) {
            dfs(n, visited);
        }
    }
}
