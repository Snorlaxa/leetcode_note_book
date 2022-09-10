package snorlaxa.com.lab.algorithm.acwing.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * AC.797
 */
public class Differ {
    private static final int[] differs = new int[100010];
    private static final int[] nums = new int[100010];

    private static void insert(int l, int r, int c) {
        differs[l] += c;
        differs[r + 1] -= c;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        String line = buffer.readLine();
        String[] params = line.split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        line = buffer.readLine();
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) nums[i + 1] = Integer.parseInt(words[i]);

        // 构造差分
        for (int i = 1; i <= n; i++) insert(i, i, nums[i]);

        while (m-- > 0) {
            line = buffer.readLine();
            int[] opers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            insert(opers[0], opers[1], opers[2]);
        }
        for (int i = 1; i <= n; i++) differs[i] += differs[i - 1];
        for (int i = 1; i <= n; i++) System.out.print(differs[i] + " ");
    }
}
