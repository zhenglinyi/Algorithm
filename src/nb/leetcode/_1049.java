package nb.leetcode;

public class _1049 {
}

class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for (int stone : stones) {
            sum+=stone;
        }
        int target=sum/2;
        int[] dp=new int[target+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >=stones[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        //在计算target的时候，target = sum / 2 因为是向下取整，所以sum - dp[target] 一定是大于等于dp[target]的。
        return (sum-dp[target])-dp[target];
    }
}
