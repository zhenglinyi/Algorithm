package nb.jianzhi_offer;

//时间限制 递归gg
/*class Solution {
    public int fib(int n) {

        int result = n<=1 ?  n : fib(n-1)+fib(n-2);
        result= result % 1000000007;
        return result;
    }
}*/

//动态规划
class Solution {
    public int fib(int n) {
        if(n<=1) return n;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
            dp[i]=dp[i]%1000000007;
        }
        return dp[n];
    }
}

//
/*class Solution {
    public int fib(int n) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}*/

public class jianzhi_10 {

}
