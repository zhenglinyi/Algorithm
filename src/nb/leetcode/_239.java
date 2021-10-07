package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _239 {
}
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque=new LinkedList<>();
        int length=nums.length;
        int[] res=new int[length-k+1];
        int index=0;
        for (int i = 0; i < length; i++) {
            //保证队列的单调性
            while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.pollLast();
            }
            deque.addLast(nums[i]);
            //刚刚组成k大小的窗口
            if(i==k-1){
                res[index++]=deque.peekFirst();
            }
            //窗口开始滑动
            if(i>=k){
                if(deque.peekFirst()==nums[i-k])
                    deque.pollFirst();
                res[index++]=deque.peekFirst();
            }

        }
        return res;
    }
}