package leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/6/3 14:39
 * @题意: 字符串代表打高精度非负整数相乘
 * @题解: 模拟竖式乘法
 */
public class Lc43 {
    public static String solution(String num1, String num2) {
        int[] nums = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            int n1 = num1.charAt(i) - '0';
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n2 = num2.charAt(j) - '0';
                int sum = nums[i + j + 1] + n1 * n2;
                nums[i + j + 1] = sum % 10;
                nums[i + j] = sum / 10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (stringBuilder.length() == 0 && nums[i] == 0 && i + 1 < nums.length) continue;
            stringBuilder.append(nums[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("0", "0"));
    }
}
