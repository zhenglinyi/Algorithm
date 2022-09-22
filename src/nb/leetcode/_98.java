package nb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class _98 {
}

//中序遍历下，输出的二叉搜索树节点的数值是有序序列

class Solution {
    long maxValue=Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        //左
        boolean left=isValidBST(root.left);
        //中 大于等于不是大于
        if(maxValue>=root.val) return false;
        maxValue=root.val;
        //右
        boolean right=isValidBST(root.right);
        return left&&right;

    }
}



class Solution {
    List<Integer> resL;
    public boolean isValidBST(TreeNode root) {
        resL=new LinkedList<>();
        recur(root);
        long max=Long.MIN_VALUE;
        for (int i : resL) {
            if(i<=max)
                return false;
            max=i;
        }
        return true;
    }
    void recur(TreeNode root){
        if(root==null){
            return;
        }
        recur(root.left);
        resL.add(root.val);
        recur(root.right);
    }
}