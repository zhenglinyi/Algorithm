package nb.leetcode;

public class _55 {
}

class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length==1) return true;
        //记录跳跃的范围
        int cover=nums[0];
        for (int i = 0; i <= cover; i++) {
            //更新跳跃的范围
            cover=Math.max(i+nums[i],cover);
            //到达最后，返回  注意这里是下标，所以要减一
            if(cover>=nums.length-1) return true;
        }
        //说明不能到达最后
        return false;
    }
}
