package nb.leetcode;

import java.util.*;

public class _90 {
}

class Solution {
    List<List<Integer>> res =new ArrayList<>();
    LinkedList<Integer> tmp=new LinkedList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length==0){
            res.add(tmp);
            return res;
        }
        //先排序
        Arrays.sort(nums);
        backTracking(nums,0);
        return res;
    }
    public void backTracking(int[] nums,int startIndex){
        res.add(new ArrayList<>(tmp));
        for (int i = startIndex; i < nums.length; i++) {
            //层不可重复
            if(i>startIndex&&nums[i]==nums[i-1]){
                continue;
            }
            tmp.addLast(nums[i]);
            backTracking(nums,i+1);
            tmp.removeLast();
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
