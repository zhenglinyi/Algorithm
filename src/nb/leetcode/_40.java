package nb.leetcode;

import java.util.*;

public class _40 {
}


class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> tmp=new LinkedList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            //去重操作 同一层不能选一样的
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum+=candidates[i];
            tmp.add(candidates[i]);
            backTracking(candidates,target,sum,i+1);
            sum-=candidates[i];
            tmp.remove(tmp.size()-1);
        }
    }
}

class Solution {
    List<List<Integer>> lists = new ArrayList<>();
    Deque<Integer> deque = new LinkedList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //为了将重复的数字都放到一起，所以先进行排序
        Arrays.sort(candidates);
        //加标志数组，用来辅助判断同层节点是否已经遍历
        boolean[] flag = new boolean[candidates.length];
        backTracking(candidates, target, 0, flag);
        return lists;
    }

    public void backTracking(int[] arr, int target, int index, boolean[] flag) {
        if (sum == target) {
            lists.add(new ArrayList(deque));
            return;
        }
        for (int i = index; i < arr.length && arr[i] + sum <= target; i++) {
            //出现重复节点，同层的第一个节点已经被访问过，所以直接跳过
            if (i > 0 && arr[i] == arr[i - 1] && !flag[i - 1]) {
                continue;
            }
            flag[i] = true;
            sum += arr[i];
            deque.push(arr[i]);
            //每个节点仅能选择一次，所以从下一位开始
            backTracking(arr, target, i + 1, flag);
            int temp = deque.pop();
            flag[i] = false;
            sum -= temp;
        }
    }
}
