package nb.leetcode;

public class _541 {
}

class Solution {
    public String reverseStr(String s, int k) {
        char[] sc=s.toCharArray();
        int length=sc.length;
        for (int i = 0; i < length; i+=2*k) {
            int l=i;
            int r=i+k-1;
            reverse(sc,l,Math.min(r,length-1));
        }
        return String.valueOf(sc);
    }
    public void reverse(char[] sc,int l,int r){
        while (l<r){
            char tmp=sc[l];
            sc[l]=sc[r];
            sc[r]=tmp;
            l++;r--;
        }
    }
}
