package nb.jianzhi_offer;

import java.util.Stack;

public class jianzhi_27 {
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
//递归左右子树交换
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null)
            return null;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        root.left = mirrorTree(rightNode);
        root.right = mirrorTree(leftNode);
        return root;
    }
}
//记录下来交换
class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        Stack<TreeNode> stack = new Stack<>() {{ add(root); }};
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if(node.left != null) stack.add(node.left);
            if(node.right != null) stack.add(node.right);
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
        return root;
    }
}
