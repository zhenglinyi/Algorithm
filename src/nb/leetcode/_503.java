package nb.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class _503 {
}

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[nums.length];
        Arrays.fill(res,-1);
        for (int i = 0; i < nums.length*2; i++) {
            while (!stack.isEmpty()&&nums[i%nums.length]>nums[stack.peek()]){
                res[stack.peek()]=nums[i%nums.length];
                stack.pop();
            }
            stack.push(i%nums.length);
        }
        return res;
    }
}
