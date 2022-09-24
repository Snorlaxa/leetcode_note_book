package snorlaxa.com.lab.algorithm.acwing.notarchived.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ac802 {
    private static class Pair {
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

        public int first;
        public int second;
    }

    private static final int[] result = new int[300010];
    private static final int[] sum = new int[300010];

    private static List<Integer> all = new ArrayList<>();
    private static final List<Pair> add = new ArrayList<>();
    private static final List<Pair> query = new ArrayList<>();

    private static int find(int x) {
        int l = 0, r = all.size() - 1;
        while (l < r) { // 找大于等于x的第一个数
            int mid = l + r >> 1;
            if (all.get(mid) >= x) r = mid;
            else l = mid + 1;
        }
        return r + 1;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        String line = buffer.readLine();
        String[] params = line.split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        for (int i = 0; i < n; i++) {
            params = buffer.readLine().split(" ");
            Pair pair = new Pair(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
            add.add(pair);
            all.add(pair.first);
        }

        for (int i = 0; i < m; i++) {
            params = buffer.readLine().split(" ");
            Pair pair = new Pair(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
            query.add(pair);
            all.add(pair.first);
            all.add(pair.second);
        }
        all = all.stream().distinct().sorted().collect(Collectors.toList());
        for (Pair pair : add) {
            int x = find(pair.first);
            result[x] += pair.second;
        }

        // 预处理前缀和
        for (int i = 1; i <= all.size(); i++) sum[i] = sum[i - 1] + result[i];

        for (Pair pair : query) {
            int l = find(pair.first), r = find(pair.second);
            System.out.println(sum[r] - sum[l - 1]);
        }
    }
}
