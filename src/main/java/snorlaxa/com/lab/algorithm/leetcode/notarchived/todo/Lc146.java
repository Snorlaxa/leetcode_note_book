package snorlaxa.com.lab.algorithm.leetcode.notarchived.todo;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 余子毅
 * @Date: 2021/10/12 17:18
 * @题意: 设计LRU缓存机制，不能采用Java API
 * ["LRUCache","get","put","get","put","put","get","get"]
 * [[2],[2],[2,6],[1],[1,5],[1,2],[1],[2]]
 */
public class Lc146 {
    public static void main(String[] args) {
        String[] ops = new String[]{"LRUCache", "put", "put", "put", "put", "put", "get", "put", "get", "get", "put", "get", "put", "put", "put", "get", "put", "get", "get", "get", "get", "put", "put", "get", "get", "get", "put", "put", "get", "put", "get", "put", "get", "get", "get", "put", "put", "put", "get", "put", "get", "get", "put", "put", "get", "put", "put", "put", "put", "get", "put", "put", "get", "put", "put", "get", "put", "put", "put", "put", "put", "get", "put", "put", "get", "put", "get", "get", "get", "put", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "get", "get", "get", "put", "put", "put", "get", "put", "put", "put", "get", "put", "put", "put", "get", "get", "get", "put", "put", "put", "put", "get", "put", "put", "put", "put", "put", "put", "put"};
        int[][] vars = new int[][]{{10}, {10, 13}, {3, 17}, {6, 11}, {10, 5}, {9, 10}, {13}, {2, 19}, {2}, {3}, {5, 25}, {8}, {9, 22}, {5, 5}, {1, 30}, {11}, {9, 12}, {7}, {5}, {8}, {9}, {4, 30}, {9, 3}, {9}, {10}, {10}, {6, 14}, {3, 1}, {3}, {10, 11}, {8}, {2, 14}, {1}, {5}, {4}, {11, 4}, {12, 24}, {5, 18}, {13}, {7, 23}, {8}, {12}, {3, 27}, {2, 12}, {5}, {2, 9}, {13, 4}, {8, 18}, {1, 7}, {6}, {9, 29}, {8, 21}, {5}, {6, 30}, {1, 12}, {10}, {4, 15}, {7, 22}, {11, 26}, {8, 17}, {9, 29}, {5}, {3, 4}, {11, 30}, {12}, {4, 29}, {3}, {9}, {6}, {3, 4}, {1}, {10}, {3, 29}, {10, 28}, {1, 20}, {11, 13}, {3}, {3, 12}, {3, 8}, {10, 9}, {3, 26}, {8}, {7}, {5}, {13, 17}, {2, 27}, {11, 15}, {12}, {9, 19}, {2, 15}, {3, 16}, {1}, {12, 17}, {9, 1}, {6, 19}, {4}, {5}, {5}, {8, 1}, {11, 7}, {5, 2}, {9, 28}, {1}, {2, 2}, {7, 4}, {4, 22}, {7, 24}, {9, 26}, {13, 28}, {11, 26}};

        LRUCache cache = new LRUCache(vars[0][0]);
        System.out.println("size:" + vars[0][0]);
        for (int i = 1; i < ops.length; i++) {
            String op = ops[i];
            if (op.equals("put")) {
                System.out.println("put: " + vars[i][0] + "-" + vars[i][1]);
                cache.put(vars[i][0], vars[i][1]);
            } else {
                System.out.println("get: " + vars[i][0] + "=" + cache.get(vars[i][0]));
            }
        }
    }
}


class Node {
    int key;
    int val;
    Node next;
    Node pre;

    Node(int key, int val, Node pre, Node next) {
        this.key = key;
        this.val = val;
        this.pre = pre;
        this.next = next;
    }

}

class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final Node head, tail;

    /**
     * 模仿LinkedHashMap，用双向链表记录写入的顺序，插入时把新增节点拼接到链表后面，如果插入的数量超过容量，就删除链表头的节点
     * 定义头尾的作用：
     * 尾部：写入的最后一个节点
     * 头部：写入的第一个节点，当某个节点被使用了，应该放在尾部还是头部
     * 头->尾越来越新，被使用相当于刷新
     */
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1, null, null);
        this.tail = new Node(-1, -1, head, null);
        this.head.next = tail;
    }

    public void put(int key, int value) {
        Node res = map.get(key);
        if (res == null) {
            // 没有加载过
            // 相同key覆盖时，要维护双向链表的值
            if (map.size() >= capacity) {
                // 从链表头部去除最久不用的节点
                map.remove(head.next.key);
                // 删除链表节点
                head.next.next.pre = head;
                head.next = head.next.next;
            }
            res = new Node(key, value, tail.pre, tail);
            Node temp = tail.pre;
            tail.pre = res;
            temp.next = res;
            map.put(key, res);
        } else {
            res.val = value;
            refresh(res);
        }
    }

    public int get(int key) {
        // 当使用一次，就把使用的节点放到尾部
        Node current = map.get(key);
        if (current != null) {
            refresh(current);
            return current.val;
        }
        return -1;
    }

    private void moveToTail(Node current) {
        // 插入
        tail.pre.next = current;
        current.pre = tail.pre;
        tail.pre = current;
        current.next = tail;
    }

    private void removeFromList(Node current) {
        // 断开
        current.pre.next = current.next;
        current.next.pre = current.pre;
    }

    private void refresh(Node current) {
        removeFromList(current);
        moveToTail(current);
    }
}