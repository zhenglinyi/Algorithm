package nb.leetcode;

public class _106 {
}


class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder,0,inorder.length,postorder,0,postorder.length);
    }

    public TreeNode build(int[] inorder,int inLeft,int inRight,
                          int[] postorder,int postLeft,int postRight){
        //没有节点返回空
        if(inRight==inLeft) return null;
        //后序数组postorder里最后一个即为根节点
        int rootVal=postorder[postRight-1];
        TreeNode root=new TreeNode(rootVal);
        int rootIndex=0;
        //根据根节点的值找到该值再中序数组inorder里的位置
        for (int i = inLeft; i < inRight; i++) {
            if(inorder[i]==rootVal){
                rootIndex=i;
                break;
            }
        }
        //根据rootIndex划分左右子树
        root.left=build(inorder,inLeft,rootIndex,postorder,postLeft,postLeft+(rootIndex-inLeft));
        root.right=build(inorder,rootIndex+1,inRight,postorder,postLeft+(rootIndex-inLeft),postRight-1);
        return root;
    }

}
