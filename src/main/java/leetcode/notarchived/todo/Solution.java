package leetcode.notarchived.todo;

class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        if (r < 0) return r;
        while (l <= r) {
            int mid = l + r >> 1;
            // mid分割的前半部分有序，可以用于缩小x的范围
            if (nums[l] <= nums[mid]) {
                // 如果x也在旋转数组前半部分并且在mid的前面，就往这边搜索，其他条件往另一边搜索
                if (nums[mid] == target) return mid;
                if (nums[l] <= target && nums[mid] > target) {
                    r = mid - 1;
                } else {
                    // 如果用l=mid，mid是已经被处理过一次的，当l=r时，就无需再处理，所以while循环用的while(l<r)
                    // 而用l=mid+1，mid+1是没有被处理的，此时赋值给l，再去比较l与r时，遇到l=r则需要继续处理，
                    // 因为l还没有被处理，所以while循环用的while(l<=r)
                    // 这里因为l=mid会导致死循环问题，本来只要mid=l+r+1>>1就可以处理，但是同时又有另一种情况要处理，
                    // 所以使用l=mid不方便，则使用while(l<=r)，
                    // 不过这样跳出后结果不好处理，所以应该在循环就处理结果比较合适
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
}