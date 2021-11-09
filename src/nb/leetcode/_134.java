package nb.leetcode;

public class _134 {
}

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //记录当前剩余
        int curSum=0;
        //记录总剩余
        int totalSum=0;
        int start=0;
        for (int i = 0; i < gas.length; i++) {
            int rest=gas[i]-cost[i];
            curSum+=rest;
            totalSum+=rest;
            if(curSum<0){//当前剩余小于零，从零重新开始
                curSum=0;
                start=i+1;
            }

        }
        //总剩余小于零 说明不行
        if(totalSum<0) return -1;
        return start;
    }
}
