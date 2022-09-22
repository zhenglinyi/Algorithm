package nb.leetcode;

public class _494 {
}

//本题要如何使表达式结果为target，
//
//既然为target，那么就一定有 left组合 - right组合 = target。
//
//left + right等于sum，而sum是固定的。
//
//公式来了， left - (sum - left) = target -> left = (target + sum)/2 。
//
//target是固定的，sum是固定的，left就可以求出来。
//
//此时问题就是在集合nums中找出和为left的组合。
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
        //填满容量为j - nums[i]的背包，有dp[j - nums[i]]种方法。
        for (int i = 0; i < nums.length; i++) {
            for (int j = tmp; j >=nums[i] ; j--) {
                dp[j]+=dp[j-nums[i]];
            }
        }
        return dp[tmp];

    }
}
class Solution {
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}


