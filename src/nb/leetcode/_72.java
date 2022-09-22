package nb.leetcode;

public class _72 {
}


class Solution {
    public int minDistance(String word1, String word2) {
        int l1=word1.length();
        int l2=word2.length();
        int[][] dp=new int[l1+1][l2+1];
        for (int i = 0; i <=l1; i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <=l2; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                //
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1]=dp[i][j];
                }else{
                    //删除word1,删除word2,替换word1
                    dp[i+1][j+1]= Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i][j])+1;
                }

            }
        }
        return dp[l1][l2];

    }
}

class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp=new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0]=i;
        }
        for (int i = 0; i <= word2.length(); i++) {
            dp[0][i]=i;
        }
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <=word2.length() ; j++) {
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    //删除或着增加，增加word1相当于删除word2
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]);
                    dp[i][j]=Math.min(dp[i-1][j-1],dp[i][j]);
                    dp[i][j]+=1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}