package nb.leetcode;

import java.util.HashMap;
import java.util.Map;

public class _383 {
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            char tmp=magazine.charAt(i);
            map.put(tmp,map.getOrDefault(tmp,0)+1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char tmp=ransomNote.charAt(i);
            map.put(tmp,map.getOrDefault(tmp,0)-1);
            if(map.get(tmp)<0)
                return false;
        }
        return true;

    }
}
//用数组
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        //记录杂志字符串出现的次数
        int[] arr = new int[26];
        int temp;
        for (int i = 0; i < magazine.length(); i++) {
            temp = magazine.charAt(i) - 'a';
            arr[temp]++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            temp = ransomNote.charAt(i) - 'a';
            //对于金信中的每一个字符都在数组中查找
            //找到相应位减一，否则找不到返回false
            if (arr[temp] > 0) {
                arr[temp]--;
            } else {
                return false;
            }
        }
        return true;
    }
}
