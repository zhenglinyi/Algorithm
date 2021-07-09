package nb.jianzhi_offer;

import java.util.HashMap;

public class jianzhi_07 {
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

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    int[] preorder;
    HashMap<Integer,Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i],i);
        }
        return recur(0,0,inorder.length - 1);

    }
    //根节点索引对应preorder中的顺序，中序遍历左边界和中序遍历右边界对应inorder中的顺序
    //根节点索引，中序遍历左边界，中序遍历右边界
    TreeNode recur(int root,int left,int right){
        //递归终止
        if(left > right)
            return null;
        //建立根节点
        TreeNode node = new TreeNode(preorder[root]);
        //划分根节点、左子树、右子树 查找根节点在中序遍历 inorder 中的索引 i
        int i = dic.get(preorder[root]);
        //开启左子树递归
        node.left = recur(root + 1,left,i - 1);
        //开启右子树递归
        //i - left + root + 1含义为 根节点索引 + 左子树长度 + 1
        node.right = recur(root + i - left + 1,i + 1,right);
        //回溯返回根节点
        return node;
    }
}
