package nb.leetcode;

public class _699 {
}


class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root==null) return null;
        //当前节点赋值右子树
        if(root.val<low){
            root=trimBST(root.right,low,high);
        }else if(root.val>high){//当前节点复制左子树
            root=trimBST(root.left,low,high);
        }else{//左右子树遍历
            root.left=trimBST(root.left,low,high);
            root.right=trimBST(root.right,low,high);
        }
        return root;
    }
}
