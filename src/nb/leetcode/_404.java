package nb.leetcode;

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
