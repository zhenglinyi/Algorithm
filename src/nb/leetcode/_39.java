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
