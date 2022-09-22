package nb.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _1763 {
}

class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (j - i + 1 > ans.length() && check(s.substring(i, j + 1))) ans = s.substring(i, j + 1);
            }
        }
        return ans;
    }
    boolean check(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) set.add(c);
        for (char c : s.toCharArray()) {
            char a = Character.toLowerCase(c), b = Character.toUpperCase(c);
            if (!set.contains(a) || !set.contains(b)) return false;
        }
        return true;
    }
}

//二进制记录解法
class Solution {
    public String longestNiceSubstring(String s) {
        int n=s.length();
        int maxPos=0;
        int maxLen=0;
        for (int i = 0; i < n; i++) {
            int lower=0;
            int upper=0;
            for (int j = i; j < n; j++) {
                if(Character.isLowerCase(s.charAt(j))){
                    lower |=1<<(s.charAt(j)-'a');
                }else{
                    upper|=1<<(s.charAt(j)-'A');
                }
                //如果更长，更新一下最长的开始位置和长度
                if(lower==upper&&j-i+1>maxLen){
                    maxPos=i;
                    maxLen=j-i+1;
                }
            }
        }
        return s.substring(maxPos,maxPos+maxLen);
    }
}

