package snorlaxa.com.lab.algorithm.acwing.notarchived.done;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ac801 {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader(in);
        int n = Integer.parseInt(buffer.readLine());
        int[] nums = Arrays.stream(buffer.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int num : nums) {
            int i = 0;
            while (num > 0) {
                num -= lowbit(num);
                i++;
            }
            System.out.print(i + " ");
        }
    }

    /**
     * x与上自己的负数，即与上x取反加一，会出现如下情况：
     * x:        10010100
     * ~x：      01101011
     * ~x+1:     01101100
     * x&-x:     00001000
     *
     * @param x 原始数据
     * @return 最后一位1构成的二进制数
     */
    private static int lowbit(int x) {
        return x & -x;
    }
}
