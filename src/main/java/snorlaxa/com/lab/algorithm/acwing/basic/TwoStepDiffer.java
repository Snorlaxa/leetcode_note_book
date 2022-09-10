package snorlaxa.com.lab.algorithm.acwing.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * AC.798
 */
public class TwoStepDiffer {
    private static final int N = 1010;
    private static final int[][] differs = new int[N][N];
    private static final int[][] nums = new int[N][N];

    private static void insert(int[] opers) {
        int row1 = opers[0], col1 = opers[1], row2 = opers[2], col2 = opers[3], c = opers[4];
        differs[row1][col1] += c;
        differs[row2 + 1][col1] -= c;
        differs[row1][col2 + 1] -= c;
        differs[row2 + 1][col2 + 1] += c;
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        String line = buffer.readLine();
        String[] params = line.split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int q = Integer.parseInt(params[2]);
        for (int i = 0; i < n; i++) {
            line = buffer.readLine();
            String[] words = line.split(" ");
            for (int j = 0; j < m; j++) {
                nums[i + 1][j + 1] = Integer.parseInt(words[j]);
            }
        }

        // 构造差分
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                insert(new int[]{i, j, i, j, nums[i][j]});

        while (q-- > 0) {
            line = buffer.readLine();
            int[] opers = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            insert(opers);
        }
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++)
                differs[i][j] += differs[i - 1][j] + differs[i][j - 1] - differs[i - 1][j - 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++)
                System.out.print(differs[i][j] + " ");
            System.out.println();
        }
    }
}
