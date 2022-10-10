package snorlaxa.com.lab.algorithm.leetcode.notarchived.done.lc200to299;

public class Lc275 {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (citations[mid] >= n - mid) { // 找到第一个当前值比剩余长度要大的数
                r = mid; // 可能在左边或者mid
            } else {
                l = mid + 1;
            }
        }
        return Math.min(citations[r], n - r);
    }

    public static void main(String[] args) {
        int i = hIndex(new int[]{2});
//        i = hIndex(new int[]{0, 1, 3, 5});
        System.out.println(i);
    }
}
