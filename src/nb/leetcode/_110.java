package nb.leetcode;

public class _110 {
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root)!=-1;
    }
    public int getHeight(TreeNode root){
        if(root==null) return 0;
        int leftHeight=getHeight(root.left);
        if(leftHeight==-1) return -1;
        int rightHeight=getHeight(root.right);
        if(rightHeight==-1) return -1;

        return Math.abs(leftHeight-rightHeight)>1?-1:Math.max(leftHeight,rightHeight)+1;

    }

}
