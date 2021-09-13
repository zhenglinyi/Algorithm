package nb.jianzhi_offer;

public class jianzhi_14 {
}

class Solution {
    public int cuttingRope(int n) {
        if(n<3)return n-1;
        int a=n/3,b=n%3;
        if(b==0) return (int)Math.pow(3,a);
        if(b==1) return (int)Math.pow(3,a-1)*4;
        return (int)Math.pow(3,a)*2;
    }

    //动态规划
    public int cuttingRope(int n) {
        if(n<=3)return n-1;
        int[] dp = new int[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int len=4;len<=n;len++){
            for(int k=2;k<len-1;k++){
                dp[len]=Math.max(dp[len],dp[k]*dp[len-k]);
            }
            //优化
//            for(int k=2;k<=len/2;k++){
//                dp[len]=Math.max(dp[len],dp[k]*dp[len-k]);
//            }
        }
        return dp[n];
    }
}
