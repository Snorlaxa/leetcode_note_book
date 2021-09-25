package snorlaxa.com.lab.algorithn;

import org.junit.Test;
import snorlaxa.com.lab.algorithm.base.Node;


/**
 * @Author: 余子毅
 * @Date: 2021/7/14 9:45
 */
public class NodeTest {
    @Test
    public void treeNodePrintTest() {
        int[][] nums = new int[][]{{2,3}, {1,3},{1}};
        Node node = Node.fromMatrix(nums);

    }
}
