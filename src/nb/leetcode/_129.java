package nb.leetcode;

public class _129 {
}



class Solution {
    int tmp=0;
    int res=0;
    public int sumNumbers(TreeNode root) {
        backTrack(root);
        return res;
    }
    public void backTrack(TreeNode root){
        if(root.left==null&&root.right==null){
            res+=tmp*10+root.val;
            return;
        }
        tmp=tmp*10+root.val;
        if(root.left!=null)
            backTrack(root.left);
        if(root.right!=null)
            backTrack(root.right);
        tmp/=10;
    }
}

//东哥写法
class Solution {
    StringBuilder path = new StringBuilder();
    int res = 0;

    public int sumNumbers(TreeNode root) {
        // 遍历一遍二叉树就能出结果
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序遍历位置，记录节点值
        path.append(root.val);
        if (root.left == null && root.right == null) {
            // 到达叶子节点，累加路径和
            res += Integer.parseInt(path.toString());
        }
        // 二叉树递归框架，遍历左右子树
        traverse(root.left);
        traverse(root.right);

        // 后续遍历位置，撤销节点值
        path.deleteCharAt(path.length() - 1);

    }
}