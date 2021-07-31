package nb.jianzhi_offer;

public class jianzhi_19 {
}



class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length()+1,n=p.length()+1;
        boolean[][] dp=new boolean[m][n];
        dp[0][0]=true;
        //初始化首行
        for (int j = 2; j < n; j+=2) {
            dp[0][j]=dp[0][j-2]&&p.charAt(j-1)=='*';
        }
        //状态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2]||dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.');
                }else{
                    dp[i][j]=dp[i - 1][j - 1] && (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1));

                }
            }
        }
        return dp[m-1][n-1];
    }
}