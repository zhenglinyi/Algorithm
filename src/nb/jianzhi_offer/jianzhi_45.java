package nb.jianzhi_offer;

import java.util.Arrays;

public class jianzhi_45 {
}

//自定义排序

//快排版本
class Solution {
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for(int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for(String s : strs)
            res.append(s);
        return res.toString();
    }
    void quickSort(String[] strs, int l, int r) {
        if(l >= r) return;
        int i = l, j = r;
        String tmp = strs[i];
        while(i < j) {
            //字符串大小（字典序）对比的实现方法
            while((strs[j] + strs[l]).compareTo(strs[l] + strs[j]) >= 0 && i < j) j--;
            while((strs[i] + strs[l]).compareTo(strs[l] + strs[i]) <= 0 && i < j) i++;
            tmp = strs[i];
            strs[i] = strs[j];
            strs[j] = tmp;
        }
        strs[i] = strs[l];
        strs[l] = tmp;
        quickSort(strs, l, i - 1);
        quickSort(strs, i + 1, r);
    }
}

//字符串的值拼起来要小 然后做排序
class Solution {
    public String minNumber(int[] nums) {
        String[] strs=new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i]=String.valueOf(nums[i]);
        }
        Arrays.sort(strs,(x,y)->(x+y).compareTo(y+x));
        StringBuilder res=new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }
}