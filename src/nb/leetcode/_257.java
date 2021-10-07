package nb.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _257 {
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
class Solution {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        recur(root);
        return res;
    }
    public void recur(TreeNode root){
        path.add(String.valueOf(root.val));
        if(root.left==null&&root.right==null){
            String tmp=String.join("->",path);
            res.add(tmp);
        }
        if(root.left!=null){
            recur(root.left);

        }
        if(root.right!=null){
            recur(root.right);
        }
        //回溯
        path.remove(path.size()-1);

    }
}
