package nb.leetcode;

public class _222 {
}
class Solution {
    /**
     * 针对完全二叉树的解法
     *
     * 满二叉树的结点数为：2^depth - 1
     */
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth) {// 左子树是满二叉树
            // 2^leftDepth其实是 （2^leftDepth - 1） + 1 ，左子树 + 根结点
            return (1 << leftDepth) + countNodes(root.right);
        } else {// 右子树是满二叉树
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode root) {
        int depth = 0;
        while (root != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }
}


class Solution {
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftHeight=0,rightHeight=0;
        while(left!=null){
            left=left.left;
            leftHeight++;
        }
        while (right!=null){
            right=right.right;
            rightHeight++;
        }
        if(leftHeight==rightHeight){
            return (2 << leftHeight)-1;//注意(2<<1) 相当于2^2，所以leftHeight初始为0
        }
        return countNodes(root.left)+countNodes(root.right)+1;
    }
}

class Solution {
    public int countNodes(TreeNode root) {
        //退出条件
        if (root == null) return 0;

        int leftHeight = 0, rightHeight = 0;
        TreeNode left = root.left;
        TreeNode right = root.right;
        while (left != null) {
            left = left.left;
            leftHeight++;
        }
        while (right != null) {
            right = right.right;
            rightHeight++;
        }
        //如果是满二叉树
        if (leftHeight == rightHeight) {
            return (2 << leftHeight) - 1;
        }
        //不是满二叉树看左右子树是不是满二叉树
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}




