package nb.leetcode;

public class _53 {
}
//贪心
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        int res=Integer.MIN_VALUE;
        int tmp=0;
        for (int i = 0; i < nums.length; i++) {
            tmp+=nums[i];
            res=Math.max(res,tmp);
            if(tmp<0) tmp=0;
        }
        return res;
    }
}