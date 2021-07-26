package nb.jianzhi_offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class jianzhi_56_2 {
}



class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.merge(num,1,Integer::sum);
            if(map.get(num)==3) map.remove(num);
        }
        return new ArrayList<Map.Entry<Integer,Integer>>(map.entrySet()).get(0).getKey();
    }
}

class Solution {
    // 使用 HashMap 记录各个数字出现的次数
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap();

        for(int i = nums.length - 1; i >= 0; --i){
            int key = nums[i];
            if(!map.containsKey(key)){
                // 如果之前没有遇到这一数字，则放入 map 中
                map.put(key, 1);
            }else{
                // 如果之前遇到过这一数字，则出现次数加 1
                map.put(key, map.get(key) + 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if(entry.getValue() == 1){
                return entry.getKey();
            }
        }

        return -1;
    }
}
//考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 33 的倍数。
//因此，统计所有数字的各二进制位中 11 的出现次数，并对 33 求余，结果则为只出现一次的数字。

class Solution {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
class Solution{
    public int singleNumber(int[] nums) {
        int []counts =new int[32];//32位数组保存int值,保存每一位1的个数
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j]+= num&1;
                num>>>=1;
            }
        }
        int res=0,m=3;//数字出现三次，每一位的和都是三的倍数
        for (int i = 0; i <32; i++) {
            res<<=1;
            res|=counts[31-i]%m;
        }
        return res;
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}



