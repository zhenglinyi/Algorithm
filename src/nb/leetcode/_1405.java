package nb.leetcode;

import java.util.PriorityQueue;

public class _1405 {
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        //大根堆
        PriorityQueue<int[]> q=new PriorityQueue<>((x,y)->(y[1]-x[1]));
        //记录abc的数量
        if(a>0) q.add(new int[]{0,a});
        if(b>0) q.add(new int[]{1,b});
        if(c>0) q.add(new int[]{2,c});
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            int[] cur=q.remove();
            int n=sb.length();
            //说明前面两个字符和当前字符相等了，需要换一个字符
            if(n>=2&&sb.charAt(n-1)-'a'==cur[0]&&sb.charAt(n-2)-'a'==cur[0]){
                //没别的字符了，推出就完事了
                if(q.isEmpty()) break;
                int[] next=q.remove();
                sb.append((char)(next[0]+'a'));
                next[1]--;
                if(next[1]!=0) q.add(next);
                q.add(cur);

            }else{
                sb.append((char)(cur[0]+'a'));
                cur[1]--;
                if(cur[1]!=0) q.add(cur);
            }
        }
        return sb.toString();
    }
}
