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

class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0],nums[1]);
        //分成两部分，不包括头和不包括尾
        return Math.max(robDp(nums,0,nums.length-2),robDp(nums,1,nums.length-1));

    }
    int robDp(int[] nums,int start,int end){
        int[] dp=new int[nums.length];
        dp[start]=nums[start];
        dp[start+1]= Math.max(nums[start],nums[start+1]);
        for (int i = start+2; i <= end; i++) {
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[end];
    }
}
