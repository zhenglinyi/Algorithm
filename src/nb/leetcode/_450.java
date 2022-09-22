package nb.leetcode;

public class _450 {
}

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(root.val>key){
            root.left=deleteNode(root.left,key);
        }else if(root.val<key){
            root.right=deleteNode(root.right,key);
        }else{
            if(root.left==null&&root.right==null){
                return null;
            }else if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                TreeNode tmp=root.left;
                TreeNode cur=root.right;

//                root.left=null;
                while(cur.left!=null){
                    cur=cur.left;
                }
                //再把它加到最后面
                cur.left=tmp;
                return root.right;
            }
        }
        return root;
    }
}

