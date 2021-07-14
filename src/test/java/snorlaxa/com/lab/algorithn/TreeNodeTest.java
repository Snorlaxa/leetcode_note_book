package snorlaxa.com.lab.algorithn;

import org.junit.Test;
import snorlaxa.com.lab.algorithm.base.TreeNode;

/**
 * @Author: 余子毅
 * @Date: 2021/7/14 9:45
 */
public class TreeNodeTest {
    @Test
    public void treeNodePrintTest() {
        Integer[] nums = new Integer[]{2, 1, null, null, 3};
        TreeNode treeNode = TreeNode.fromArray(nums);
        TreeNode.print(treeNode);
    }
}
