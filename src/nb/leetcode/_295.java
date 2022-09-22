package nb.leetcode;

import java.util.PriorityQueue;
import java.util.TreeMap;

public class _295 {
}

class MedianFinder {

    PriorityQueue<Integer> l = new PriorityQueue<>((a, b)->b-a);
    PriorityQueue<Integer> r = new PriorityQueue<>((a, b)->a-b);

    public void addNum(int num) {
        int s1 = l.size(), s2 = r.size();
        if (s1 == s2) {
            if (r.isEmpty() || num <= r.peek()) {
                l.add(num);
            } else {
                l.add(r.poll());
                r.add(num);
            }
        } else {
            if (l.peek() <= num) {
                r.add(num);
            } else {
                r.add(l.poll());
                l.add(num);
            }
        }
    }

    public double findMedian() {
        int s1 = l.size(), s2 = r.size();
        if (s1 == s2) {
            return (l.peek() + r.peek()) / 2.0;
        } else {
            return l.peek();
        }
    }
}
//奇数个的时候保持大根堆多一个
class MedianFinder {
    PriorityQueue<Integer> bigHeap=new PriorityQueue<>((o1, o2) -> Integer.compare(o2,o1));
    PriorityQueue<Integer> smallHeap=new PriorityQueue<>();
    public MedianFinder() {

    }

    public void addNum(int num) {
        int s1=bigHeap.size();
        int s2=smallHeap.size();
        if(s1==s2){
            if(s1==0){
                bigHeap.add(num);
            }else if(num<smallHeap.peek()){
                bigHeap.add(num);
            }else{
                bigHeap.add(smallHeap.poll());
                smallHeap.add(num);
            }
        }else{
            if(num>bigHeap.peek()){
                smallHeap.add(num);
            }else{
                smallHeap.add(bigHeap.poll());
                bigHeap.add(num);
            }
        }
    }

    public double findMedian() {
        int s1=bigHeap.size();
        int s2=smallHeap.size();
        if(s1==s2){
            return (bigHeap.peek()+smallHeap.peek())/2.0;
        }else{
            return bigHeap.peek();
        }
    }
}

//进阶
class MedianFinder {

    TreeMap<Integer, Integer> head = new TreeMap<>(), tail = new TreeMap<>();
    int[] arr = new int[101];
    int a, b, c;

    public void addNum(int num) {
        if (num >= 0 && num <= 100) {
            arr[num]++;
            b++;
        } else if (num < 0) {
            head.put(num, head.getOrDefault(num, 0) + 1);
            a++;
        } else if (num > 100) {
            tail.put(num, tail.getOrDefault(num, 0) + 1);
            c++;
        }
    }

    public double findMedian() {
        int size = a + b + c;
        if (size % 2 == 0) return (find(size / 2) + find(size / 2 + 1)) / 2.0;
        return find(size / 2 + 1);
    }

    int find(int n) {
        if (n <= a) {
            for (int num : head.keySet()) {
                n -= head.get(num);
                if (n <= 0) return num;
            }
        } else if (n <= a + b) {
            n -= a;
            for (int i = 0; i <= 100; i++) {
                n -= arr[i];
                if (n <= 0) return i;
            }
        } else {
            n -= a + b;
            for (int num : tail.keySet()) {
                n -= tail.get(num);
                if (n <= 0) return num;
            }
        }
        return -1; // never
    }
}

作者：AC_OIer
        链接：https://leetcode-cn.com/problems/find-median-from-data-stream/solution/gong-shui-san-xie-jing-dian-shu-ju-jie-g-pqy8/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
