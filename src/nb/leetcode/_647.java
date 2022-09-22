package nb.leetcode;

public class _647 {
}


class Solution {
    public int countSubstrings(String s) {
        int res=0;
        if(s==null||s.length()==0) return 0;
        boolean[][] dp=new boolean[s.length()][s.length()];
        for (int i = s.length()-1; i >=0 ; i--) {
            for (int j = i; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if(i==j){
                        dp[i][j]=true;
                        res++;
                    }else if(j-i==1){
                        dp[i][j]=true;
                        res++;
                    }else if(dp[i+1][j-1]){
                        dp[i][j]=true;
                        res++;
                    }
                }
            }
        }
        return res;

    }
}
class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp=new boolean[s.length()][s.length()];
        int res=0;
        for (int i = 0; i < s.length(); i++) {
            dp[i][i]=true;
            res++;
        }
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i < j ; i++) {
                if(j-i>0){
                    if(s.charAt(i)==s.charAt(j)){
                        if(j-i==1){
                            dp[i][j]=true;
                            res++;
                        }else{
                            dp[i][j]=dp[i+1][j-1];
                            if(dp[i][j])
                                res++;
                        }

                    }
                }

            }
        }
        return res;
    }
}


class Solution {
    public int countSubstrings(String s) {
        int len, ans = 0;
        if (s == null || (len = s.length()) < 1) return 0;
        //总共有2 * len - 1个中心点
        for (int i = 0; i < 2 * len - 1; i++) {
            //通过遍历每个回文中心，向两边扩散，并判断是否回文字串
            //有两种情况，left == right，right = left + 1，这两种回文中心是不一样的
            int left = i / 2, right = left + i % 2;
            while (left >= 0 && right < len && s.charAt(left) == s.charAt(right)) {
                //如果当前是一个回文串，则记录数量
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}