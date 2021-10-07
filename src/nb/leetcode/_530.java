package nb.leetcode;

public class _530 {
}

class Solution {
    long minValue=Long.MAX_VALUE;
    //如果这样定义会溢出，所以minValue使用long
    int preValue=Integer.MIN_VALUE;

    public int getMinimumDifference(TreeNode root) {
        recur(root);
        return (int)minValue;
    }
    public void recur(TreeNode root){
        if(root==null) return;
        //左
        recur(root.left);
        //中
        if(minValue>(long)root.val-(long)preValue){
            minValue=(long)root.val-(long)preValue;
        }
        preValue=root.val;
        recur(root.right);

    }

}

class Solution {
    TreeNode pre;// 记录上一个遍历的结点
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if(root==null)return 0;
        traversal(root);
        return result;
    }
    public void traversal(TreeNode root){
        if(root==null)return;
        //左
        traversal(root.left);
        //中
        if(pre!=null){
            result = Math.min(result,root.val-pre.val);
        }
        pre = root;
        //右
        traversal(root.right);
    }
}
