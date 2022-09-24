package snorlaxa.com.lab.algorithm.acwing.notarchived.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ac2816 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        String line = buffer.readLine();
        String[] params = line.split(" ");
        int n = Integer.parseInt(params[0]);
        int m = Integer.parseInt(params[1]);
        String[] A = buffer.readLine().split(" ");
        String[] B = buffer.readLine().split(" ");

        if (n > m) {
            System.out.println("No");
            return;
        }
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (B[j].equals(A[i])) i++;// 命中相同字符
            j++;
        }
        if (i < n) System.out.println("No");
        else System.out.println("Yes");
    }
}
