package nb.leetcode;

import java.util.Stack;

public class _404 {
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        //左子树的左叶子总和
        int leftValue=sumOfLeftLeaves(root.left);
        //右子树的左叶子总和
        int rightValue=sumOfLeftLeaves(root.right);
        //如果当前节点存在左叶字节点
        int curValue=0;
        if(root.left!=null&&root.left.right==null&&root.left.left==null){
            curValue=root.left.val;
        }
        int sum=leftValue+rightValue+curValue;
        return sum;
    }
}
class Solution {
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum=0;
        recur(root);
        return sum;

    }
    void recur(TreeNode root){
        if(root==null) return;
        recur(root.left);
        recur(root.right);
        if(root.left!=null&&root.left.left==null&&root.left.right==null){
            sum+=root.left.val;
        }
    }
}

class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<> ();
        stack.add(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left != null && node.left.left == null && node.left.right == null) {
                result += node.left.val;
            }
            if (node.right != null) stack.add(node.right);
            if (node.left != null) stack.add(node.left);
        }
        return result;
    }
}
