package nb.leetcode;

public class _153 {
}


class Solution {
    public int findMin(int[] nums) {
        int length=nums.length;
        if(length==1){
            return nums[0];
        }
        int left=0;
        int right=length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(mid!=0&&nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid]>=nums[0]){
                if(nums[mid]<nums[length-1])
                    return nums[0];
                else
                    left=mid+1;
            }else{
                right=mid-1;
            }

        }
        return left;
    }
}

class Solution {
    public int findMin(int[] nums) {
        int length=nums.length;
        if(length==1){
            return nums[0];
        }
        int left=0;
        int right=length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            //当前值小于最右边的值，说并当前值在最小值右边，舍弃右区间
            if(nums[mid]<=nums[length-1]){
                right=mid-1;
            //当前值大于最右边的值，说明当前值在最小值左边，舍弃左区间
            }else{
                left=mid+1;
            }

        }
        return nums[left];
    }
}