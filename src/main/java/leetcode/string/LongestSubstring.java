package leetcode.string;

/**
 * @Author: Yzy
 * @Date: 2021/1/11 19:13
 *
 */
public class LongestSubstring {

    /**
     * 滑动窗口+位图
     *
     * @param str
     * @return
     */
    public static int solution(String str) {
        if (str.length() == 0) {
            return 0;
        }
        int[] map = new int[256];
        int maxLen = 0, right = 0, left = 0, len = str.length();
        while (left < len) {
            if (right < len && map[str.charAt(right)] == 0) {
                map[str.charAt(right)] = 1;
                right++;
            } else {
                //遇到重复数据，记录长度，把左侧的标志设置为0
                map[str.charAt(left)] = 0;
                if (maxLen < right - left) {
                    maxLen = right - left;
                }
                left++;
            }
        }

        return maxLen;
    }

    /**
     * 滑动窗口模型
     * @param str
     * @return
     */
    public static int model(String str){
        if(str.length()==0){
            return 0;
        }
        int left = 0,right=0,len=str.length();
        // 循环跳出条件是左指针到达末尾
        while(left<len){
            //右指针移动，扩张窗口
            //窗口扩张条件要在右指针位置判断之后，防止越界
            if(right<len && condition()){
                right++;
            }else {
                //TODO 记录最值

                //左指针前移，缩小窗口
                left++;
            }
        }
        // 返回最值
        return 0;
    }

    /**
     * 滑动窗口扩张条件
     * @return
     */
    private static boolean condition(){
        return false;
    }

    public static void main(String[] args) {
        int count = solution("pwwkew");
        System.out.println(count);
    }

}
