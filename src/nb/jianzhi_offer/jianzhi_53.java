package nb.jianzhi_offer;

public class jianzhi_53 {
}



class Solution {

    public int search(int[] nums, int target) {
        //搜索右边界 right
        int i=0,j=nums.length-1;
        while(i<=j){
            int m=(i+j)/2;
            if(nums[m]<=target)
                i=m+1;
            else
                j=m-1;
        }
        int right=i;
        //若数组中无target,则提前返回
        if(j>=0&&nums[j]!=target)
            return 0;
        i = 0; j = nums.length - 1;
        // 搜索左边界
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] < target)
                i = m + 1;
            else
                j = m - 1;
        }
        int left = j;

        return right-left-1;
    }

}
//由于数组 numsnums 中元素都为整数，
// 因此可以分别二分查找 targettarget 和 target - 1target−1 的右边界，
// 将两结果相减并返回即可

class Solution {
    public int search(int[] nums, int target) {
        return helper(nums, target) - helper(nums, target - 1);
    }
    int helper(int[] nums, int tar) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] <= tar) i = m + 1;
            else j = m - 1;
        }
        return i;
    }
}


class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                if (nums[low] == nums[high]) {
                    return high - low + 1;
                }
                if (nums[low] < target) {
                    low++;
                }
                if (nums[high] > target) {
                    high--;
                }
            }

        }
        return 0;
    }
}-


