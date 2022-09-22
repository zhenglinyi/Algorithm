package nb.leetcode;

import java.util.Stack;

public class _42 {
}


class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack=new Stack<>();
        int res=0;
        for (int i = 0; i < height.length; i++) {
            while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int mid=stack.pop();
                if(!stack.isEmpty()){
                    int left=stack.peek();
                    int right=i;
                    int w=right-left-1;
                    int h=Math.min(height[left],height[right])-height[mid];
                    res+=w*h;
                }

            }
            stack.push(i);
        }
        return res;
    }
}
//备忘录优化
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] lmax=new int[n];
        int[] rmax=new int[n];
        lmax[0]=height[0];
        rmax[n-1]=height[n-1];
        for (int i = 1; i < n; i++) {
            lmax[i]=Math.max(height[i],lmax[i-1]);
        }
        for (int i = n-2; i >=0 ; i--) {
            rmax[i]=Math.max(height[i],rmax[i+1]);
        }
        int res=0;
        for (int i = 0; i < n; i++) {
            res+=Math.min(lmax[i],rmax[i])-height[i];
        }
        return res;

    }
}
//双指针
class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int lmax=0;
        int rmax=0;
        int res=0;
        while(left<=right){
            lmax=Math.max(lmax,height[left]);
            rmax=Math.max(rmax,height[right]);
            if(lmax>rmax){
                res+=rmax-height[right];
                right--;
            }else{
                res+=lmax-height[left];
                left++;
            }
        }
        return res;
    }
}