package nb.leetcode;

public class _80 {
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            if(res<2||nums[res-2]!=nums[i]){
                nums[res++]=nums[i];
            }
        }
        return res;
    }
}