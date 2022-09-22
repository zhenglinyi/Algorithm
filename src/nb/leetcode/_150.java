package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _150 {
}

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack=new LinkedList<>();
        for (String token : tokens) {
            if(token.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(token.equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }else if(token.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if(token.equals("/")) {
                int num1=stack.pop();
                int num2=stack.pop();
                //注意这里
                stack.push(num2/num1);
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
