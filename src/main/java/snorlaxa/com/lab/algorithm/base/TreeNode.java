package snorlaxa.com.lab.algorithm.base;

import java.util.*;

/**
 * @Author: 余子毅
 * @Date: 2021/6/23 0:53
 * 二叉树节点
 */
public class TreeNode {
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

    public static void print(TreeNode root) {
        int deep = maxDeep(root);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty() && deep > 0) {
            int n = deque.size();
            System.out.print("[ ");
            for (int i = 0; i < n; i++) {
                TreeNode treeNode = deque.poll();
                if (treeNode == null) {
                    System.out.print("null ");
                } else {
                    System.out.print(treeNode.val + " ");
                    deque.offer(treeNode.left);
                    deque.offer(treeNode.right);
                }
            }
            System.out.println("]");
            deep--;
        }
    }

    private static int maxDeep(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDeep(root.left), maxDeep(root.right));
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
