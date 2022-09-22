package nb.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _347 {
}

//小根堆
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res=new int[k];
        //先用哈希表统计频率
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //创建一个小根堆
        PriorityQueue<Map.Entry<Integer,Integer>> minHeap=new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());
        //使得小根堆只保存k个数，就是最大的k个
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            minHeap.offer(entry);
            if(minHeap.size()>k){
                minHeap.poll();
            }

        }
        //反向存入
        for (int i = 0; i < k; i++) {
            res[k-i-1]=minHeap.poll().getKey();
        }
        return res;
    }
}

//大根堆
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap=new PriorityQueue<>((o1,o2)->o2.getValue()-o1.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.offer(entry);
        }
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=maxHeap.poll().getKey();
        }
        return res;

    }
}