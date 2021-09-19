package nb.leetcode;

public class _69 {
    public static int mySqrt(int x) {
        int l=0,r=x;
        while(l<=r){
            int m=l+(r-l)/2;
            if((long)m*m==x){
                return m;
            }else if((long)m*m>x){
                r=m-1;
            }else if((long)m*m<x){
                l=m+1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        mySqrt(8);

    }
}


class Solution {
    public int mySqrt(int x) {
        int l=0,r=x;
        while(l<=r){
            int m=l+(r-l)/2;
            if(m*m==x){
                return m;
            }else if((long)m*m>x){
                r=m-1;
            }else if((long)m*m<x){
                l=m+1;
            }
        }
        return r;
    }
}