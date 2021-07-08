package nb.jianzhi_offer;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> numset = new HashSet<>();
        for (int num : nums) {
            //加入失败说明重复了，add方法返回false
            if(!numset.add(num)){
                return num;
            }

        }
        return -1;

    }
}
public class jianzhi_03 {
}
