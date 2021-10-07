package nb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _501 {
}


class Solution {
    List<Integer> res=new ArrayList<>();
    int maxCount=0;
    int count=0;
    TreeNode pre=null;
    public int[] findMode(TreeNode root) {
        find(root);
        int[] resArr=new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resArr[i]=res.get(i);
        }
        return resArr;
    }
    public void find(TreeNode root) {
        if(root==null) return;
        //左
        find(root.left);
        //中
        int rootValue=root.val;
        if(pre==null||rootValue!=pre.val){
            count=1;
        }else {
            count++;
        }
        if(count>maxCount){
            res.clear();
            res.add(rootValue);
            maxCount=count;
        }else if(count==maxCount){
            res.add(rootValue);
        }
        pre=root;
        //右
        find(root.right);



    }
}