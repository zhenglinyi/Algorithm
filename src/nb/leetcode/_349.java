package nb.leetcode;

import java.util.HashSet;
import java.util.Set;

public class _349 {
}


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set=new HashSet<>();
        Set<Integer> resSet=new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if(set.contains(i)){
                resSet.add(i);
            }
        }
        int[] resArr=new int[resSet.size()];
        int index=0;
        for (int i : resSet) {
            resArr[index++]=i;
        }
        return resArr;
    }
}