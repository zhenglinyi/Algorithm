package nb.leetcode;

public class _96 {
}


class Solution {
    public int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n; i++) {
            for (int j = 1; j <= i ; j++) {
                //左边的节点的情况乘右边的节点的情况
                dp[i]+=dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}
class Solution {
    public int numTrees(int n) {
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i <=n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i]=dp[j]*dp[i-1-j];
            }

        }
        return dp[n];


    }
}
