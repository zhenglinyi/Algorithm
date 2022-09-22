package nb.leetcode;

public class _5 {
}
//动态规划
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        int max=1;
        String res=s.substring(0,1);
        boolean[][] dp=new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=true;
        }
        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i; j < s.length(); j++) {
                if(j>i){
                    if(s.charAt(i)==s.charAt(j)){
                        if(j-i==1){
                            dp[i][j]=true;
                            if(max<2){
                                max=2;
                                res=s.substring(i,j+1);
                            }

                        }else{
                            dp[i][j]=dp[i+1][j-1];
                            if(dp[i][j]&&max<j-i+1){
                                max=j-i+1;
                                res=s.substring(i,j+1);
                            }
                        }
                    }
                }

            }
        }
        return res;
    }
}
class Solution {
    public String longestPalindrome(String s) {
        if(s.length()==1) return s;
        int max=1;
        int left=0;
        int right=1;
        boolean[][] dp=new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i; j < s.length(); j++) {
                if(j>i){
                    if(s.charAt(i)==s.charAt(j)){
                        //两位
                        if(j-i==1){
                            dp[i][j]=true;
                            //两位以上
                        }else{
                            dp[i][j]=dp[i+1][j-1];
                        }
                        if(dp[i][j]&&max<j-i+1){
                            max=j-i+1;
                            left=i;
                            right=j;
                        }
                    }
                    //一位
                }else{
                    dp[i][j]=true;
                }

            }
        }
        return s.substring(left,right+1);
    }
}

//中心扩散
class Solution {
    public String longestPalindrome(String s) {
        int max=1;
        String res=s.substring(0,1);
        if(s.length()==1) return s;
        for (int i = 0; i < s.length(); i++) {

            int len1=expandAroundCenter(s,i,i);

            int len2=expandAroundCenter(s,i,i+1);
            int len=Math.max(len1,len2);
            if(len>max){
                res=s.substring(i-(len-1)/2,i+len/2+1);
                max=len;
            }
        }
        return res;
    }
    int expandAroundCenter(String s,int left,int right){
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}