package nb.jianzhi_offer;

public class jianzhi_55_2 {
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
    public boolean isBalanced(TreeNode root) {
        return recur(root)!=-1;
    }
    int recur(TreeNode root){
        if(root==null) return 0;
        int left=recur(root.left);
        if(left==-1) return -1;
        int right=recur(root.right);
        if(right==-1) return -1;
        return Math.abs(left-right)<2?Math.max(left,right)+1:-1;
    }
}