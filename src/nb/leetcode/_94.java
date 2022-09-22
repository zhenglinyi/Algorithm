package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _94 {
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        if(root==null) return res;

        TreeNode cur=root;
        while(cur!=null||!deque.isEmpty()){
            if(cur!=null){
                deque.push(cur);
                cur=cur.left;

            }else{
                cur=deque.pop();
                res.add(cur.val);
                cur=cur.right;
            }

        }
        return res;
    }
}
