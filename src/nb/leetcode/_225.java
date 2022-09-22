package nb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _225 {
}

class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
    }

    public int pop() {
        int size=queue1.size();
        for (int i = 0; i < size-1; i++) {
            queue2.offer(queue1.poll());
        }
        int res=queue1.poll();
        Queue<Integer> tmp=queue1;
        queue1=queue2;
        queue2=tmp;
        return res;
    }

    public int top() {
        int size=queue1.size();
        for (int i = 0; i < size-1; i++) {
            queue2.offer(queue1.poll());
        }
        int res=queue1.poll();
        queue2.offer(res);
        Queue<Integer> tmp=queue1;
        queue1=queue2;
        queue2=tmp;
        return res;


    }

    public boolean empty() {
        return queue1.isEmpty();
    }
}


class MyStack {

    Queue<Integer> queue1; // 和栈中保持一样元素的队列
    Queue<Integer> queue2; // 辅助队列

    /** Initialize your data structure here. */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue2.offer(x); // 先放在辅助队列中
        while (!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> queueTemp;
        queueTemp = queue1;
        queue1 = queue2;
        queue2 = queueTemp; // 最后交换queue1和queue2，将元素都放到queue1中
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue1.poll(); // 因为queue1中的元素和栈中的保持一致，所以这个和下面两个的操作只看queue1即可
    }

    /** Get the top element. */
    public int top() {
        return queue1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue1.isEmpty();
    }
}
