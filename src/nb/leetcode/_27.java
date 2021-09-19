package nb.leetcode;

public class _27 {
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int slow=0;
        int fast;
        for(fast=0;fast<nums.length;fast++){
            if(nums[fast]!=val){
                nums[slow++]=nums[fast];
            }
        }
        return slow;
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            while(nums[r]==val&&l<=r){
                r--;
            }
            while(nums[l]!=val&&l<=r){
                l++;
            }
            if(l<=r){
                int tmp=nums[l];
                nums[l]=nums[r];
                nums[r]=tmp;
            }

        }

        return l;
    }
}