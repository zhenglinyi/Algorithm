package nb.leetcode;

public class _213 {
}

class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int len = nums.length;
        if (len == 1)
            return nums[0];
        return Math.max(robDp(nums,0,nums.length-1),robDp(nums,1,nums.length));

    }
    public int robDp(int[] nums,int start,int end){
        //x=dp[i-2],y=dp[i-1],z=dp[i]
        int x=0,y=0,z=0;
        for (int i = start; i <end; i++) {
            y=z;
            z=Math.max(x+nums[i],y);
            x=y;
        }
        return z;
    }

}
