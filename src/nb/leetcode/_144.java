package nb.leetcode;

import java.util.LinkedList;
import java.util.List;

public class _144 {
}


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
    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        res=new LinkedList<>();
        traverse(root);
        return res;
    }
    public void traverse(TreeNode root){
        if(root==null) return;
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);

    }

}