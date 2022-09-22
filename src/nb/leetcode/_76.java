package nb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _76 {
}

class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> hs=new HashMap<>();
        HashMap<Character,Integer> ht=new HashMap<>();
        //记录t中的字符
        for (int i = 0; i <t.length() ; i++) {
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i),0)+1);
        }
        //滑动
        int r;
        int l=0;
        int length=Integer.MAX_VALUE;
        int cnt=0;//记录滑动窗口中的字符是t中的数量
        String res="";
        for (r = 0; r <s.length() ; r++) {
            char tmpr=s.charAt(r);
            hs.put(tmpr,hs.getOrDefault(tmpr,0)+1);
            if(ht.containsKey(tmpr)&&hs.get(tmpr)<=ht.get(tmpr))
                cnt++;
            char tmpl=s.charAt(l);
            while(l<r&&(!ht.containsKey(tmpl)||hs.get(tmpl)>ht.get(tmpl))){
                hs.put(tmpl,hs.get(tmpl)-1);
                l++;
                tmpl=s.charAt(l);
            }
            if(cnt==t.length()&&r-l+1<length){
                length=r-l+1;
                res=s.substring(l,r+1);
            }
        }
        return res;

    }
}
class Solution {
    public String minWindow(String s, String t) {
        //需要的
        Map<Character,Integer> need=new HashMap<>();
        //窗口
        Map<Character,Integer> window=new HashMap<>();
        //统计需要的
        for (int i = 0; i < t.length(); i++) {
            char tmpc=t.charAt(i);
            need.put(tmpc,need.getOrDefault(tmpc,0)+1);
        }
        //左右指针
        int left=0;
        int right=0;
        int valid=0;

        String res="";
        int length=Integer.MAX_VALUE;

        while(right<s.length()){
            // c 是将移入窗口的字符
            char c=s.charAt(right);
            // 右移窗口
            right++;
            // 进行窗口内数据的一系列更新
            if(need.containsKey(c)){
                window.put(c,window.getOrDefault(c,0)+1);
                if(need.get(c).equals(window.get(c))){
                    valid++;
                }
            }
            // 判断左侧窗口是否要收缩
            while(valid==need.size()){
                // 在这里更新最小覆盖子串
                if(right-left<length){
                    length=right-left;
                    res=s.substring(left,right);
                }
                // d 是将移出窗口的字符
                char d=s.charAt(left);
                // 左移窗口
                left++;
                // 进行窗口内数据的一系列更新
                if(need.containsKey(d)){
                    if(need.get(d).equals(window.get(d))){
                        valid--;
                    }

                    window.put(d,window.get(d)-1);
                }

            }
        }
        return res;

    }
}
//???
class Solution {
    public String minWindow(String s, String t) {
        char[] chars = s.toCharArray(), chart = t.toCharArray();
        int n = chars.length, m = chart.length;

        int[] hash = new int[128];
        for (char ch : chart) hash[ch]--;

        String res = "";
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            hash[chars[i]]++;
            if (hash[chars[i]] <= 0) cnt++;
            while (cnt == m && hash[chars[j]] > 0) hash[chars[j++]]--;
            if (cnt == m)
                if (res.equals("") || res.length() > i - j + 1)
                    res = s.substring(j, i + 1);
        }
        return res;
    }
}
