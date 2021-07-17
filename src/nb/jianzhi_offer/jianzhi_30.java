package nb.jianzhi_offer;

import java.util.Stack;

public class jianzhi_30 {
}

//辅助栈
class MinStack {
    public Stack<Integer> stack,stack_sup;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        stack_sup = new Stack<>();

    }

    public void push(int x) {
        stack.push(x);
        if(stack_sup.empty()||stack_sup.peek()>=x){
            stack_sup.push(x);
        }

    }

    public void pop() {
        //equals不要写==，因为返回值是object类型的
        if(stack.peek().equals(stack_sup.peek())){
            stack_sup.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stack_sup.peek();
    }
}

