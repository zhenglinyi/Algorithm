package nb.leetcode;

public class _45 {
}

class Solution {
    public int jump(int[] nums) {
        if(nums==null||nums.length==0||nums.length==1){
            return 0;
        }
        int count=0;
        //当前的覆盖最大区域
        int curCover=0;
        //最大的覆盖区域
        int nextCover=0;
        for (int i = 0; i < nums.length; i++) {
            //在可覆盖区域内更新最大的覆盖区域
            nextCover=Math.max(nextCover,i+nums[i]);
            //说明当前一步，再跳一步就到达了末尾
            if(nextCover>=nums.length-1){
                count++;
                break;
            }
            //走到当前覆盖的最大区域时，更新下一步可达的最大区域
            if(i==curCover){
                curCover=nextCover;
                count++;
            }

        }
        return count;
    }
}
