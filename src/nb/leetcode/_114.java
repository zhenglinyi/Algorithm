package nb.leetcode;

public class _114 {
}

class Solution {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }
    public TreeNode flattenTree(TreeNode root){
        if(root==null) return null;
        TreeNode left=flattenTree(root.left);
        TreeNode right=flattenTree(root.right);
        //左子树不为空
        if(left!=null){
            //加入左子树
            root.right=left;
            root.left=null;
            TreeNode tmp=root;
            while(tmp.right!=null){
                tmp=tmp.right;
            }
            //加入右子树
            tmp.right=right;
            //左子树为空
        }else{
            //只需要加入右子树
            root.right=right;
        }

        return root;
    }
}

//东哥方法
class Solution {
    // 定义：将以 root 为根的树拉平为链表
    void flatten(TreeNode root) {
        // base case
        if (root == null) return;

        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
