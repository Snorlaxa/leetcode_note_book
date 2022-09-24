package snorlaxa.com.lab.algorithm.acwing.notarchived.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ac803 {
    private static class Pair {
        public Pair(int left, int second) {
            this.left = left;
            this.right = second;
        }

        public int left;
        public int right;
    }

    private static final List<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        int n = Integer.parseInt(buffer.readLine());
        for (int i = 0; i < n; i++) {
            String[] params = buffer.readLine().split(" ");
            Pair pair = new Pair(Integer.parseInt(params[0]), Integer.parseInt(params[1]));
            pairs.add(pair);
        }

        pairs.sort(Comparator.comparingInt(o -> o.left));
        int count = 0;

        for (int i = 0; i < pairs.size(); ) {
            int right = pairs.get(i).right;
            int j = i + 1;
            while (j < pairs.size() && right >= pairs.get(j).left) {
                // 交集
                right = Math.max(pairs.get(j).right, right);
                j++;
            }
            i = j;
            count++;
        }
        System.out.println(count);
    }
}
