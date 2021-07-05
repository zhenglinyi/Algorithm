package nb.jianzhi_offer;

import java.util.Stack;
/*用两个栈实现队列*/


class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public CQueue() {
        //第一个栈，插入节点
        stack1 = new Stack<>();
        //第二个栈，删除节点
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(!stack2.empty()){
            return stack2.pop();
        }else{
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            return stack2.isEmpty() ? -1 : stack2.pop();
        }
    }
}
public class jianzhi_09 {

}
