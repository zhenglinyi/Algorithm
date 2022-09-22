package nb.leetcode;

public class _622 {
}
class MyCircularQueue {
    private int[] queue;
    private int headIndex;
    private int count;
    private int capacity;
    /** Initialize your data structure here. Set the size of the queue to be k. */

    public MyCircularQueue(int k) {
        this.capacity=k;
        this.queue=new int[k];
        this.headIndex=0;
        this.count=0;
    }
    //往队列里添加元素
    public boolean enQueue(int value) {
        if(this.count==this.capacity)
            return false;
        this.queue[(this.headIndex+this.count)%this.capacity]=value;
        this.count+=1;
        return true;
    }

    public boolean deQueue() {
        if(this.count==0)
            return false;
        this.headIndex=(this.headIndex+1)%this.capacity;
        this.count-=1;
        return true;
    }

    public int Front() {
        if(this.count==0)
            return -1;
        return this.queue[this.headIndex];
    }

    public int Rear() {
        if(this.count==0)
            return -1;
        int tailIndex=(this.headIndex+this.count-1)%this.capacity;
        return this.queue[tailIndex];
    }

    public boolean isEmpty() {
        return (this.count == 0);

    }

    public boolean isFull() {
        return (this.count == this.capacity);
    }
}