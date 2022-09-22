package nb.leetcode;

public class _100 {
}
class Solution {
    public boolean compare(TreeNode tree1, TreeNode tree2) {

        if(tree1==null && tree2==null)return true;
        if(tree1==null || tree2==null)return false;
        if(tree1.val!=tree2.val)return false;
        // 此时就是：左右节点都不为空，且数值相同的情况
        // 此时才做递归，做下一层的判断
        boolean compareLeft = compare(tree1.left, tree2.left);       // 左子树：左、 右子树：左
        boolean compareRight = compare(tree1.right, tree2.right);    // 左子树：右、 右子树：右
        boolean isSame = compareLeft && compareRight;                  // 左子树：中、 右子树：中（逻辑处理）
        return isSame;

    }
    boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }
}