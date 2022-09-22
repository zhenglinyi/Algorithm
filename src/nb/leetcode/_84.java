package nb.leetcode;

import java.util.Stack;

public class _84 {
}

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        // 数组扩容，在头和尾各加入一个元素
        int [] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int index = 0; index < heights.length; index++){
            newHeights[index + 1] = heights[index];
        }

        heights = newHeights;
        for (int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty()&&heights[i]<heights[stack.peek()]){
                if(!stack.isEmpty()){
                    int mid = stack.peek();
                    stack.pop();
                    int left = stack.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    res = Math.max(res, w * h);
                }
            }
            stack.push(i);
        }
        return res;


    }
}
