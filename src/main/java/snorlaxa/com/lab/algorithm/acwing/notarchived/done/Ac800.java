package snorlaxa.com.lab.algorithm.acwing.notarchived.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ac800 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        String line = buffer.readLine();
        String[] params = line.split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        int x = Integer.parseInt(params[2]);
        int[] A = Arrays.stream(buffer.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(buffer.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0, j = m - 1; i < n && j >= 0; ) {
            int sum = A[i] + B[j];
            if (sum == x) {
                System.out.println(i + " " + j);
                break;
            } else if (sum < x) {
                i++;
            } else {
                j--;
            }
        }
    }
}
