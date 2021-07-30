package nb.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

public class jianzhi_48 {
}

//动态规划 + 哈希表
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dic=new HashMap<>();
        int res=0,tmp=0;
        for (int j = 0; j <s.length() ; j++) {
            int i=dic.getOrDefault(s.charAt(j),-1); // 获取索引 i
            dic.put(s.charAt(j),j);// 更新哈希表
            tmp=tmp<j-i?tmp+1:j-i;// dp[j - 1] -> dp[j]
            res=Math.max(res,tmp);// max(dp[j - 1], dp[j])
        }
        return res;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dic=new HashMap<>();
        int l=s.length();
        if(l==0)
            return 0;
        int res=0;
        int[] dp=new int[l+1];
        dp[0]=1;
        for (int j = 0; j <l; j++) {
            int i=dic.getOrDefault(s.charAt(j),-1);
            dic.put(s.charAt(j),j);
            dp[j+1]=j-i>dp[j]?dp[j]+1:j-i;
            res=Math.max(res,dp[j+1]);
        }
        return res;

    }

}
//动态规划 + 线性遍历
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int res = 0, tmp = 0;
        for(int j = 0; j < s.length(); j++) {
            int i = j - 1;
            while(i >= 0 && s.charAt(i) != s.charAt(j)) i--; // 线性查找 i
            tmp = tmp < j - i ? tmp + 1 : j - i; // dp[j - 1] -> dp[j]
            res = Math.max(res, tmp); // max(dp[j - 1], dp[j])
        }
        return res;
    }
}
//滑动窗口+动态规划
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> dic=new HashMap<>();
        int i=-1,res=0;
        for (int j = 0; j < s.length(); j++) {
            i=Math.max(i,dic.getOrDefault(s.charAt(j),-1));// 更新左指针 i
            dic.put(s.charAt(j),j);// 哈希表记录
            res=Math.max(res,j-i); // 更新结果
        }
        return res;
    }
}



