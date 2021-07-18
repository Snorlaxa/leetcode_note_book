package snorlaxa.com.lab.algorithn;

import org.junit.Test;
import snorlaxa.com.lab.algorithm.base.TreeNode;

import java.util.HashMap;
import java.util.Properties;

/**
 * @Author: 余子毅
 * @Date: 2021/7/14 9:45
 */
public class TreeNodeTest {
    @Test
    public void treeNodePrintTest() {
        Integer[] nums = new Integer[]{2, 1, 3, 4, 5,6,7,null,null,55,30};
        TreeNode treeNode = TreeNode.fromArray(nums);
        TreeNode.print(treeNode);
    }

    @Test
    public void hashmapTest() {
        HashMap<String, String> h = new HashMap<>();
        h.put(null, "adfadsa");
        h.put(null, "sdfafad");
        h.get(null);
        Properties properties = new Properties();

    }
}
