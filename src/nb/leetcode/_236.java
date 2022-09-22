package nb.leetcode;

public class _236 {
}


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==p||root==q||root==null) return  root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        //左右都有返回，说明找到了
        if(left!=null&&right!=null) return root;
        //说明从右子树找到了公共节点
        if(left==null&&right!=null) return right;
        //说明从左子树找到了公共节点
        if(right==null&&left!=null) return left;

        return null;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q) return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left==null&&right==null){
            return null;
        }else if(left!=null&&right==null){
            return left;
        }else if(right!=null&&left==null){
            return right;
        }else{
            return root;
        }

    }
}