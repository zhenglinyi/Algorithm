package nb.jianzhi_offer;

import java.util.Deque;
import java.util.LinkedList;

public class jianzhi_59 {
}


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0) return new int[0];
        Deque<Integer> deque=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        //未形成窗口
        for (int i = 0; i < k; i++) {
            while(!deque.isEmpty()&&deque.peekLast()<nums[i])
                deque.removeLast();//删除比当前节点小的
            deque.addLast(nums[i]);//加入当前节点
        }
        //已经形成了第一个窗口，把第一个结果记下来
        res[0]=deque.peekFirst();
        //形成窗口后
        for (int i = k; i < nums.length; i++) {
            if(deque.peekFirst()==nums[i-k])
                deque.removeFirst();//上一个窗口最左元素和deque中元素相同时删除
            while(!deque.isEmpty()&&deque.peekLast()<nums[i])//和右边界比较
                deque.removeLast();//删除比当前节点小的
            deque.addLast(nums[i]);//加入当前节点
            res[i-k+1]=deque.peekFirst();
        }
        return res;
    }
}