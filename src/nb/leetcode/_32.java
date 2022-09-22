package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _32 {
}
//官方题解
/*具体做法是我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」，这样的做法主要是考虑了边界条件的处理，栈里其他元素维护左括号的下标：

        对于遇到的每个 \text{‘(’}‘(’ ，我们将它的下标放入栈中
        对于遇到的每个 \text{‘)’}‘)’ ，我们先弹出栈顶元素表示匹配了当前右括号：
        如果栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
        如果栈不为空，当前右括号的下标减去栈顶元素即为「以该右括号为结尾的最长有效括号的长度」*/

class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxans=Math.max(maxans,i-stack.peek());
                }
            }
        }
        return maxans;
    }
}

class Solution {
    public int longestValidParentheses(String s) {
        int left=0,right=0,maxlength=0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxlength=Math.max(maxlength,2*right);
            }else if(right>left){
                left=right=0;
            }
        }
        left=right=0;
        for (int i = s.length()-1; i >=0 ; i--) {
            if(s.charAt(i)=='('){
                left++;
            }else{
                right++;
            }
            if(left==right){
                maxlength=Math.max(maxlength,2*right);
            }else if(left>right){
                left=right=0;
            }
        }
        return maxlength;
    }
}