package nb.leetcode;

public class _209 {
}

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int resL=Integer.MAX_VALUE;
        int l=0,r=0;
        int tmpSum=0;
        for (r = 0; r <nums.length ; r++) {
            tmpSum+=nums[r];
            //要用while
            while(tmpSum>=target){
                int temL=r-l+1;
                resL=resL<temL?resL:temL;
                tmpSum-=nums[l];
                l++;

            }
        }
        return resL==Integer.MAX_VALUE?0:resL;
    }
}
