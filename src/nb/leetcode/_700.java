package nb.leetcode;

public class _700 {
}

class Solution {
    // 递归，利用二叉搜索树特点，优化
    public TreeNode searchBST(TreeNode root, int val) {
        //为空或者没有找到
        if (root == null || root.val == val) {
            return root;
        }
        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }
}
