package nb.leetcode;

public class _33 {
}

class Solution {
    //二分查找
    public int search(int[] nums, int target) {
        int length=nums.length;
        if(length==1)
            return target==nums[0]?0:-1;
        int left=0;
        int right=length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[0]){
                if(target<nums[mid]&&target>=nums[left]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{
                if(target>nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else {
                    right=mid-1;
                }
            }
        }
        return -1;
    }
}

class Solution {
    //二分查找
    public int search(int[] nums, int target) {
        int n=nums.length;
        if(n==0)
            return -1;
        if(n==1)
            return nums[0]==target?0:-1;
        int l=0;
        int r=n-1;
        while(l<=r){
            int mid=(l+r)/2;
            if(nums[mid]==target)
                return mid;
            //左边数组是有序的
            if(nums[l]<=nums[mid]){
                if(target>=nums[l]&&target<nums[mid]){
                    r=mid-1;
                }
                else{
                    l=mid+1;
                }

            }
            else{
                if(target>nums[mid]&&target<=nums[r]){
                    l=mid+1;
                }
                else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }

}
