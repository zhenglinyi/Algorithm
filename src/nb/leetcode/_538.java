package nb.leetcode;

public class _538 {
}

class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        recur(root);
        return root;

    }
    public void recur(TreeNode root){
        if(root==null) return;
        recur(root.right);
        sum+=root.val;
        root.val=sum;
        recur(root.left);

    }
}

class Solution {
    int sum=0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        root.right=convertBST(root.right);
        sum+=root.val;
        root.val=sum;
        root.left=convertBST(root.left);
        return root;
    }
}
