package nb.leetcode;

public class _53 {
}
//贪心
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int res=Integer.MIN_VALUE;
        int tmp=0;
        for (int i = 0; i < nums.length; i++) {
            tmp+=nums[i];
            res=Math.max(res,tmp);
            if(tmp<0) tmp=0;
        }
        return res;
    }
}
//dp
class Solution {
    public int maxSubArray(int[] nums) {

        int[] dp=new int[nums.length];
        int res=nums[0];
        dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            max=sum>max?sum:max;
            sum=sum<0?0:sum;
        }
        return max;
    }
}

