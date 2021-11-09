package nb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _47 {
}

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> tmp=new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used=new boolean[nums.length];
        backTracking(nums);
        return res;
    }

    public void backTracking(int[] nums){
        if(tmp.size()==nums.length){
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            if(used[i]){
                continue;
            }else{
                tmp.addLast(nums[i]);
                used[i]=true;
                backTracking(nums);
                tmp.removeLast();
                used[i]=false;
            }
        }
    }
}
