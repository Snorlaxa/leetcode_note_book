package base;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/6/23 0:53
 */
public class TreeNode {
    private final static TreeNode endNode = new TreeNode();
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {

    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    // TODO 打印树
    public static void print(TreeNode root) {

    }

    public static List<Integer> toList(TreeNode root) {
        // 层序遍历
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        List<Integer> res = new ArrayList<>();
        while (!deque.isEmpty()) {
            TreeNode cur = deque.poll();
            if (cur == null) {
                res.add(null);
                continue;
            } else
                res.add(cur.val);
            deque.offer(cur.left);
            deque.offer(cur.right);
        }
        int i = res.size() - 1;
        // 删除不必要的空值
        while (i >= 0 && res.get(i) == null) {
            res.remove(i--);
        }
        return res;
    }

    public static TreeNode fromArray(Integer[] nums) {
        return createTree(nums, 0);
    }

    private static TreeNode createTree(Integer[] nums, int index) {
        TreeNode root = null;
        // 创建以index所在节点为根节点的树
        if (index < nums.length) {
            Integer cur = nums[index];
            if (cur == null) return null;
            root = new TreeNode(cur);
            root.left = createTree(nums, 2 * index + 1);
            root.right = createTree(nums, 2 * index + 2);
        }
        return root;
    }
}
