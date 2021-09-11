# Acwing 题解

### 01背包问题

在定义状态时，通常问题是什么，状态就是什么。如此题中要求的是容量为v的背包，在n个物品中，挑选能装下的最高价值的东西。
这个定义里有两个变量，一个是容量，一个是物品数量，我们就可以设定状态为容量为j的背包，在前i个物品中，挑选出的能装下的最高价值。

得到dp[i][j]

在这个定义下，再去求状态转移方程。dp[i][j]的结果跟前i-1个物品，容量为j的背包下的状态有关，在这个状态下，选择是否要装物品i，就是状态的转移过程。 如果选择装物品i，容量就会减少v[i]，而总价值就会变成dp[i-1][
j-v[i]]+w[i]；如果不选择物品i，相当于没有操作，dp[i][j]=d[i-1][j]。

从状态转移方程可以看出计算的顺序，由于需要用到dp[i-1][j-v[i]]，这个状态必须要提前计算，所以i和j的计算需要从小到大。

### 快排

实现快排的基本思路就是分治法，核心实现逻辑在于分区逻辑。

~~~ java
private static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;

        int x = nums[left + right >> 1], i = left - 1, j = right + 1;
        while (i < j) {
            do i++; while (nums[i] < x);
            do j--; while (nums[j] > x);
            // swap
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        quickSort(nums, left, j);
        quickSort(nums, j + 1, right);
    }
~~~



分区的逻辑在于取一个值x，使得数组里左边的值都小于等于x，右边的值都大于等于x。

+ 这里为什么是小于等于和大于等于？这样不会导致排序混乱吗？

  在一次分组中，这种参杂了等于的分区确实会导致混乱，但分区完成后，分区内部再按相同的方式做一次，混乱就会被处理掉：右边的x是最小的会被放在最左边，左边的x是最大的会被放在最右边。

  所以不会导致最终的混乱，并且在实现上我们也不需要再去考虑分区完成后x最终的位置。

+ 为什么i=left -1，j=right+1？

  是为了实现上的统一。如果i=left，j=right，在查找大于和小于x的数时会向后移动，同时每次交换完成后也都要移动一次，这两次移动是分开的。如果我们每次循环开始前都移动一次，就可以把交换完成后的一次移动合并到下一次的查找移动里。但这需要让初始i和j都留一个buffer，让第一次循环时的i、j保持正常。

+ 为什么取nums[left+right>>1]作为x？

  防止时间复杂度变成O(n^2)。如果取第一个或者最后一个，当数组本身就是顺序的，就会出现这种问题，因为每次分区都分成1个数和剩余数两组。



### 归并排序

归并排序的思想跟快排有一点像，也是分治法。不同的是它需要先处理分治后的结果，再合并起来，而快排是先在原数组做分区然后再分治。

核心逻辑在合并的过程。两个有序数组合并成大的有序数组，首先对长度相等的部分进行合并，存入临时数组，再对剩余的数组进行合并。

~~~ java
private static void mergeSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int mid = left + right >> 1;

        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);
        // merge
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (nums[i] < nums[j]) temp[k++] = nums[i++];
            else temp[k++] = nums[j++];
        }
        // 处理中断后的数据
        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        // 赋值
        System.arraycopy(temp, left, nums, left, right + 1 - left);
    }
~~~





### 二分查找问题

+ 二分的核心

  取二分范围的时候，关键点是找到一个范围，在这个范围里目标值是不可能取到的，在这些范围之外就有可能取到在，这样就可以缩小范围继续查找。

+ 无法在循环中直接找出结果的二分问题

  在取二分的时候，如果能直接在循环中找出目标值，是一件比较辛运的事情，而如果找不到，就需要在跳出循环后再做判断。这种情况一般分为两种： 取靠左的结果，取靠右的结果。

  如果要取靠左的结果，比如小于某个数的最大值，相同值中的第一个值等情况，就需要在循环之外判断了。此时需要找到靠左的结果完全不可能出现的范围，
  比如取小于某个数的最大值，如果mid大于等于这个数，要找的数就不可能落在mid右边的范围里，那么查找范围就缩小到[left,mid-1]【情况1】；
  而如果mid小于这个数，要找的目标就有可能落在mid的右边或者就是mid本身，所以查找的范围就缩小到[mid,right]【情况2】.

  另一个问题是，跳出后选择left还是right作为我们的结果。我们需要注意mid被赋值给谁了，因为mid是有可能取到结果的，如果mid被赋值给了某个索引， 这个索引就是我们要返回的结果。

  上述的【情况2】中，目标有可能落在mid上，所以mid被赋值给了left，因此我们将left作为结果返回。

+ while循环的跳出条件

~~~ java

while(left<right){
    if(mid>target) left = mid;
    else right = mid-1;
}


while(left<=right){
	if(mid>target) left = mid+1;
    else right = mid-1;
}
~~~

跳出条件一般有两种：left<right*【条件1】*和left<=right*【条件2】*，两者的区别在于是否执行left=right的情况。前者会直接跳出，后者则会执行一次再跳出。这将导致跳出循环后left、right的位置有所差异。

【条件1】由于相等时也会跳出，最终的left和right可能相等也有可能right在左边、left在右边，而如果在循环中指定了left=mid或者right=mid这种缩小范围的方式，跳出后left或者right一定会有一个指向mid，如果是在符合目标条件的情况下指定left=mid或者right=mid，就可以直接用left或者right作为查找结果；

而【条件2】只有right在左边、left在右边这一种情况，这两个位置都不应该作为查找结果的索引， 因为它无法清晰地描述哪个索引代表这最终查找结果。【条件2】的这种特性表明了这种方式只适合在循环里找出最终结果并返回，而无法等循环结束后再通过左右索引判断。

相比之下【条件1】更加灵活和清晰。