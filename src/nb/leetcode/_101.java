package nb.leetcode;

public class _101 {
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return recur(root.left,root.right);
    }
    public boolean recur(TreeNode node1,TreeNode node2){
        if(node1!=null&&node2!=null){
            if(node1.val!=node2.val) return false;
            return recur(node1.left,node2.right)&&recur(node1.right,node2.left);
        }else if((node1==null&&node2!=null)||(node2==null&&node1!=null)){
            return false;
        }
        return true;
    }
}
