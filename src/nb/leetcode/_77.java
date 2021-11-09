package nb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _77 {
}

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    LinkedList<Integer> tmp=new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n,k,0);
        return res;
    }
    public void backtracking(int n,int k,int startIndex){
        if(tmp.size()==k){
            res.add(new ArrayList<>(tmp));
            return;
        }
        //这里i的范围进行剪枝，后续不满足可以保证tmp数组大小为k就剪掉
        for (int i = startIndex; i < n-(k-tmp.size())+1; i++) {
            //我写的从零开始的，所以这里写了i+1
            tmp.addLast(i+1);
            backtracking(n,k,i+1);
            tmp.removeLast();
        }

    }
}
