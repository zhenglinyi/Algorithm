package nb.jianzhi_offer;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author shkstart
 * @date 2021-07-21 14:03
 */
public class jianzhi_38 {
}

//dfs +剪枝
class Solution {
    List<String> res =new LinkedList<>();
    char[] c;
    public String[] permutation(String s) {
        c=s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);//转化为数组

    }
    public void dfs(int x){
        if(x==c.length-1){
            res.add(String.valueOf(c));//添加排列方案
            return;
        }
        HashSet<Character> set =new HashSet<>();
        for (int i = x; i <c.length ; i++) {
            if(set.contains(c[i]))
                continue;// 重复，因此剪枝
            set.add(c[i]);
            swap(i,x);// 交换，将 c[i] 固定在第 x 位
            dfs(x+1);
            swap(i,x);
        }


    }
    void swap(int a,int b){
        char temp = c[a];
        c[a]=c[b];
        c[b]=temp;
    }
}
