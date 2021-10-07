package nb.leetcode;

public class _105 {
}


class Solution {
    int[] preorder,inorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.inorder=inorder;
        this.preorder=preorder;
        return build(0,inorder.length,0,inorder.length);
    }
    public TreeNode build(int inLeft,int inRight,int preLeft,int preRight){
        if(inRight==inLeft) return null;
        int val=preorder[preLeft];
        TreeNode root=new TreeNode(val);
        int rootIndex=0;
        for (int i = inLeft; i < inRight; i++) {
            if(val==inorder[i]){
                rootIndex=i;
                break;
            }
        }
        root.left=build(inLeft,rootIndex,preLeft+1,preLeft+1+(rootIndex-inLeft));
        root.right=build(rootIndex+1,inRight,preLeft+1+(rootIndex-inLeft),preRight);
        return root;
    }
}