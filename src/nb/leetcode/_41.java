package nb.leetcode;

public class _41 {
}

//把数值放到对应数组下标的位置上，然后第一个对应下标不相等的时候就是缺失的那个值。
class Solution {
    public int firstMissingPositive(int[] nums) {
        int len=nums.length;
        for (int i = 0; i < len; i++) {
            while(nums[i]>=1&&nums[i]<=len&&nums[i]!=nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }
        for (int i = 0; i < len; i++) {
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return len+1;
    }
    public void swap(int[] nums,int i,int j){
        int tmp=nums[i];
        nums[i]=nums[j];
        nums[j]=tmp;
    }
}

