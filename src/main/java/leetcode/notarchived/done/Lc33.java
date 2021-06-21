package leetcode.notarchived.done;

/**
 * @Author: 余子毅
 * @Date: 2021/5/12 9:32
 * @题意: 在旋转数组中查找目标值，要求时间复杂度O(logn)。旋转数组指的是从随机的某位置开始，把该位置之前的数据全部移到数组末尾。如：[1,2,3,4,5,6] => [3,4,5,6,7,0,1'',2]
 * @题解: 二分的本质是找到x的确切范围，从而缩小x的搜索范围，当确定在某种情况下x在某一个范围且不在这种情况下x一定不在这个范围上时，就可以用这个性质作为二分的条件
 */
public class Lc33 {
    public static int solution(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (r < 0) return r;
        while (l <= r) {
            int mid = l + r >> 1;
            // mid分割的前半部分有序，可以用于缩小x的范围
            if (nums[mid] == target) return mid;
            if (nums[l] <= nums[mid]) {
                // 如果x也在旋转数组前半部分并且在mid的前面，就往这边搜索，其他条件往另一边搜索
                if (nums[l] <= target && nums[mid] > target) {
                    r = mid - 1;
                } else {
                    // 如果l=mid，mid是已经被处理过一次的，当l=r时，就无需再处理，所以while循环用的while(l<r)
                    // 而如果用l=mid+1，mid+1是没有被处理的，此时赋值给l，再去比较l与r时，发现l=r则需要继续处理，
                    // 因为l还没有被处理，所以while循环用的while(l<=r)
                    // 这里因为l=mid会导致死循环问题，本来只要mid=l+r+1>>1就可以处理，但是同时又有另一种情况要处理，所以使用l=mid不方便，
                    // 则使用while(l<=r)，不过这样跳出后结果不好处理，所以应该在循环就处理结果比较合适
                    // 所以最终采用了while(l<=r)加l=mid+1的处理方式。
                    l = mid + 1;
                }
            } else {
                // mid分割的后半部分有序
                // 当x落在后半部分，且x在mid后面，往这边搜索
                if (nums[r] >= target && nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 3};
        System.out.println(solution(nums, 1));
    }
}
