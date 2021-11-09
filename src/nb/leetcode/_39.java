package nb.leetcode;

import java.util.*;

public class _39 {
    //1.递归回溯不剪枝
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> combine=new ArrayList<>();
        //Arrays.sort(candidates,(o1, o2) -> o2 - o1);

        dfs(candidates,target,result,combine,0);
        return result;
    }
    public void dfs(int[] candidates, int target,List<List<Integer>> result,List<Integer> combine,int index){
        if(index==candidates.length){
            return;
        }
        if(target==0){
            result.add(new ArrayList<Integer>(combine));
            return;
        }
        //不选当前数，下一个
        dfs(candidates,target,result,combine,index+1);
        //选当前数，要保证够减
        if(target-candidates[index]>=0){
            combine.add(candidates[index]);
            dfs(candidates,target-candidates[index],result,combine,index);
            //返回以后，要把加到后边的数移出，递归返回后保证在调用处combine不受影响。
            combine.remove(combine.size()-1);
        }
    }

    public static void main(String[] args) {
        
    }


}

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> tmp=new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //利用回溯条件需要先进行排序
        Arrays.sort(candidates); // 先进行排序
        backTracking(candidates,target,0,0);
        return res;
    }
    public void backTracking(int[] candidates, int target,int sum,int startIndex){
        if(sum==target){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            // 如果 sum + candidates[i] > target 就终止遍历
            if (sum + candidates[i] > target) break;
            sum+=candidates[i];
            tmp.add(candidates[i]);
            backTracking(candidates,target,sum,i);
            sum-=candidates[i];
            tmp.remove(tmp.size()-1);
        }
    }
}
