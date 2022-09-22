package nb.leetcode;

import java.util.*;

public class _491 {
}

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> tmp=new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return res;

    }
    public void backTracking(int[] nums,int startIndex){
        //题目要求递增子序列大小至少为2
        if(tmp.size()>1){
            res.add(new ArrayList<>(tmp));
        }
        //哈希数组记录用过的数字
        int[] used = new int[201];
        for (int i = startIndex; i < nums.length; i++) {

            if(!tmp.isEmpty()&&nums[i]<tmp.getLast()||(used[nums[i] + 100] == 1)){
                continue;
            }
            used[nums[i] + 100]=1;
            tmp.addLast(nums[i]);
            backTracking(nums,i+1);
            tmp.removeLast();
        }
    }
}
class Solution {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> tmp=new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backTracking(nums,0);
        return res;

    }
    public void backTracking(int[] nums,int startIndex){
        if(tmp.size()>1){
            res.add(new ArrayList<>(tmp));
        }
//        //哈希数组记录用过的数字
//        int[] used = new int[201];
        Set<Integer> used=new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {

            if(!tmp.isEmpty()&&nums[i]<tmp.getLast()){
                continue;
            }
            if(used.contains(nums[i]))
                continue;
            used.add(nums[i]);
//            used[nums[i] + 100]=1;
            tmp.addLast(nums[i]);
            backTracking(nums,i+1);
            tmp.removeLast();
        }
    }
}
