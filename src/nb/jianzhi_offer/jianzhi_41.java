package nb.jianzhi_offer;

import java.util.PriorityQueue;
import java.util.Queue;

public class jianzhi_41 {
}

//小根堆和大根堆
class MedianFinder {
    Queue<Integer>A,B;
    /** initialize your data structure here. */
    public MedianFinder() {
        A=new PriorityQueue<>();//小根堆，保存较大的一半
        B=new PriorityQueue<>((x,y)->(y-x));//大根堆，保存较小的一半
    }

    public void addNum(int num) {
        if(A.size()!=B.size()){
            A.add(num);
            B.add(A.poll());
        }else{
            B.add(num);
            A.add(B.poll());
        }
    }

    public double findMedian() {
        return A.size()!=B.size()?A.peek():(A.peek()+B.peek())/2.0;
    }
}