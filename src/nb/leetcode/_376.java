package nb.leetcode;

public class _376 {
}


class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums==null||nums.length<=1){
            return nums.length;
        }
        //当前差值
        int curDiff=0;
        //上一个差值
        int preDiff=0;
        int count=1;
        for (int i = 1; i <nums.length; i++) {
            curDiff=nums[i]-nums[i-1];
            if((curDiff>0&&preDiff<=0||curDiff<0&&preDiff>=0)){
                preDiff=curDiff;
                count++;
            }
        }
        return count;
    }
}