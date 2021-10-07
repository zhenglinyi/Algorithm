package nb.leetcode;

import java.util.HashMap;

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
