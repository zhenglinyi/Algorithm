package nb.jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

public class jianzhi_57_2 {
}


//数学法
class Solution {
    public int[][] findContinuousSequence(int target) {
        int i = 1;
        double j = 2.0;
        List<int[]> res = new ArrayList<>();
        while(i < j) {
            j = (-1 + Math.sqrt(1 + 4 * (2 * target + (long) i * i - i))) / 2;
            if(i < j && j == (int)j) {
                int[] ans = new int[(int)j - i + 1];
                for(int k = i; k <= (int)j; k++)
                    ans[k - i] = k;
                res.add(ans);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }
}

//滑动窗口
class Solution {
    public int[][] findContinuousSequence(int target) {
        int i=1,j=2,s=3;
        List<int[]>res=new ArrayList<>();
        while(i<j){
            if(s==target){
                int[] ans=new int[j-i+1];
                for (int k = i; k <=j; k++) {
                    ans[k-i]=k;
                }
                res.add(ans);
            }
            if(s>=target){//先减再滑动
                s-=i;
                i++;
            }else{//先滑动再减
                j++;
                s+=j;
            }
        }
        //List转数组，会自动扩充
        return res.toArray(new int[0][]);
    }
}

