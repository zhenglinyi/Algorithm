package nb.jianzhi_offer;

public class jianzhi_42 {
}

//动态规划
class Solution {
    public int maxSubArray(int[] nums) {
        int res=nums[0];
        //直接用nums数组当作dp数组
        //目标dp[i]是以第i个数结尾的包含第i个数的连续子数组的最大值
        for(int i= 1;i<nums.length;i++){
            nums[i]=nums[i-1]<0?nums[i]:nums[i]+nums[i-1];
            res=Math.max(res,nums[i]);
        }
        return res;

    }
}
