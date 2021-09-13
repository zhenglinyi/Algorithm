package nb.jianzhi_offer;

public class jianzhi_68 {

}
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while(root!=null){
            if(root.val>p.val&&root.val>q.val)
                root=root.left;
            else if(root.val<p.val&&root.val<q.val)
                root=root.right;
            else
                break;
        }
        return root;
    }

}


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        if(root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        return root;
    }
}

