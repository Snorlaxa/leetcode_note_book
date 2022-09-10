package snorlaxa.com.lab.algorithm.acwing.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * AC.796
 */
public class PrefixSum {
    private static int[][] matrix_sum;

    private static int solution(int[] position) {
        return matrix_sum[position[2]][position[3]]
                - matrix_sum[position[2]][position[1] - 1]
                - matrix_sum[position[0] - 1][position[3]]
                + matrix_sum[position[0] - 1][position[1] - 1];
    }

    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        String line = buffer.readLine();
        String[] params = line.split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int q = Integer.parseInt(params[2]);
        int[][] matrix = new int[n][m];
        matrix_sum = new int[n + 1][m + 1];

        for (int i = 0; i < n; i++) {
            line = buffer.readLine();
            String[] nums = line.split(" ");
            for (int j = 0; j < nums.length; j++) {
                matrix[i][j] = Integer.parseInt(nums[j]);
                matrix_sum[i + 1][j + 1] = matrix[i][j] + matrix_sum[i + 1][j] + matrix_sum[i][j + 1] - matrix_sum[i][j];
            }
        }

        for (int i = 0; i < q; i++) {
            line = buffer.readLine();
            if (line.isEmpty()) break;
            int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            int res = solution(nums);
            System.out.println(res);
        }
    }
}
