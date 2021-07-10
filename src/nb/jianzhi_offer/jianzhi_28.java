package nb.jianzhi_offer;

public class jianzhi_28 {
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        else
            return recur(root.left,root.right);
    }
    //递归对称比较 左的左和右的右，左的右和右的左
    boolean recur(TreeNode L,TreeNode R){
        if(L == null && R == null)
            return true;
        if(L == null || R == null || L.val != R.val)
            return false;
        return recur(L.left,R.right) && recur(L.right,R.left);
    }

}