package leetcode.array;

/**
 * @Author: snorlaxa
 * @Date: 2021/3/1 23:21
 * @题意： 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）
 * 要求：必须原地修改，只允许使用额外常数空间。
 * 如数组[1,2,3]，下一个更大的数是132，当不存在时，如[3,2,1]，需要排列成最小数[1,2,3]
 * @题解： 把右边较大的数跟左边较小的数交换，为了保证是下一个更大的数，要保证右边交换上去的数尽量小，并且交换位置能让最终数值在所有增大的可能性中最小。
 * 首先找左边的数，很明显是从右往左找第一个降序的数据，这样交换后的位置最低。
 * 再找右边的数，为了保证交换数尽可能小，应该找第一个比左边数大的值。
 * 注意此时右边是完全降序的，为了让数据最小，应该右边升序排列，所以将右边数组翻转
 */
public class NextPermutation {
    public void solution(int[] nums){
        int n = nums.length;
        int small = -1,index = -1;
        int i,cur;
        for(i=n-1;i>=0;i--){
            cur=nums[i];
            if(cur<small){
                small=cur;
                index=i;
                // get small one
                break;
            }
            small=cur;
        }
        for(i=n-1;i>index;i--){
            cur=nums[i];
            if(cur>small){
                // exchange with bigger one
                int temp = nums[index];
                nums[index]=cur;
                nums[i]=temp;
                break;
            }
        }
        //reverse
        reverse(nums,index+1,n-1);
    }
    public void reverse(int[] nums,int left,int right){
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }
    public void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
