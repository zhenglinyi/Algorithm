package nb.jianzhi_offer;

import java.util.ArrayList;
import java.util.List;

public class jianzhi_54 {
}



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

//中右左，二叉搜索数树中序遍历逆遍历，是递增数列
class Solution {
    List<Integer> list=new ArrayList<>();
    int tmp=0;
    int res;
    int K;
    public int kthLargest(TreeNode root, int k) {
        K=k;
        dfs(root);
        return res;
    }
    void dfs(TreeNode cur){
        if(cur==null)
            return;
        dfs(cur.right);
        tmp++;
        if(tmp==K)
            res=cur.val;
        dfs(cur.left);
    }
}