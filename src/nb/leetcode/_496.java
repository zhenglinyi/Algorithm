package nb.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _496 {
}

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        int[] res=new int[nums1.length];
        Arrays.fill(res,-1);
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i],i);
        }
        for (int i = 0; i < nums2.length; i++) {
            while(!stack.isEmpty()&&map.containsKey(stack.peek())&&nums2[i]>stack.peek()){
                res[map.get(stack.peek())]=nums2[i];
                stack.pop();
            }
            stack.push(nums2[i]);
        }
        return res;
    }
}
