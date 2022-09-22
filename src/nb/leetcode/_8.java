package nb.leetcode;

public class _8 {
}

class Solution {
    public int myAtoi(String s) {
        int len=s.length();
        if(len==0) return 0;
        int index=0;
        //去除空格
        for (; index < len&&s.charAt(index)==' '; index++);
        // 如果已经遍历完成（针对极端用例 "      "）
        if (index == len) {
            return 0;
        }
        //正负号标记
        int sign=1;
        if(s.charAt(index)=='-'){
            sign=-1;
            index++;
        }else if(s.charAt(index)=='+'){
            index++;
        }
        int res=0;
        for (; index < len; index++) {

            if(s.charAt(index)<'0'||s.charAt(index)>'9') return res;
            int tmp=s.charAt(index)-'0';
            if(res>Integer.MAX_VALUE/10||(res== Integer.MAX_VALUE/10&&tmp>Integer.MAX_VALUE%10))
                return Integer.MAX_VALUE;
            if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&tmp>-(Integer.MIN_VALUE%10)))
                return Integer.MIN_VALUE;
            res=res*10+sign*tmp;
        }
        return res;

    }


}