package nb.jianzhi_offer;

import java.util.Stack;

/**
 * @author shkstart
 * @date 2021-07-21 13:17
 */
public class jianzhi_31 {

}
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack =new Stack<>();
        int i =0;
        for (int pu : pushed) {
            stack.push(pu);
            while(!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();
                i++;
            }

        }
        return stack.isEmpty();
    }
}
