package nb.leetcode;

public class _367 {
}

class Solution {
    public boolean isPerfectSquare(int num) {
        int l=0,r=num;
        while(l<=r){
            int m=l+(r-l)/2;
            if((long)m*m==num){
                return true;
            }else if((long)m*m>num){
                r=m-1;
            }else if((long)m*m<num){
                l=m+1;
            }
        }
        return false;
    }
}
