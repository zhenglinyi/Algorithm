package nb.leetcode;

public class _494 {
}


class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        if(Math.abs(target)>sum) return 0;
        if((sum+target)%2==1) return 0;
        int tmp=(sum+target)/2;
        if(tmp < 0) tmp = -tmp;
        int[] dp=new int[tmp+1];
        dp[0]=1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = tmp; j >=nums[i] ; j--) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[tmp];

    }
}
