package nb.jianzhi_offer;

public class jianzhi_26 {
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
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (recur(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));

    }

    public boolean recur(TreeNode A, TreeNode B) {
        if (B == null)
            return true;//说明匹配完了
        if (A == null || A.val != B.val)//说明不匹配
            return false;
        return recur(A.left, B.left) && recur(A.right, B.right);//逐节点匹配
    }
}
