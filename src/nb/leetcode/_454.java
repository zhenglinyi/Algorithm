package nb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _454 {
}


class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer,Integer> map12sum=new HashMap<>();
        Map<Integer,Integer> map34sum=new HashMap<>();
        for (int i : nums1) {
            for (int i1 : nums2) {
                map12sum.put(i+i1,map12sum.getOrDefault(i+i1,0)+1);
            }
        }
        for (int i : nums3) {
            for (int i1 : nums4) {
                map34sum.put(i+i1,map34sum.getOrDefault(i+i1,0)+1);
            }
        }
        int res=0;
        for (int sum12 : map12sum.keySet()) {
            for (int sum34 : map34sum.keySet()) {
                if(sum12+sum34==0){
                    res+=map12sum.get(sum12)*map34sum.get(sum34);
                }
            }
        }
        return res;

    }
}