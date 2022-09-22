package nb.leetcode;

public class _416 {
}

//背包的体积为sum / 2
//背包要放入的商品（集合里的元素）重量为 元素的数值，价值也为元素的数值
//背包如果正好装满，说明找到了总和为 sum / 2 的子集。
//背包中每一个元素是不可重复放入。
class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int num : nums) {
            sum+=num;
        }
        //总和为奇数，不能平分
        if(sum % 2 != 0) return false;
        sum=sum/2;

        int[] dp=new int[sum+1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >=nums[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        if(dp[sum]==sum) return true;
        return false;

    }
}


