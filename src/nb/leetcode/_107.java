package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _107 {
}

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        List<List<Integer>> res=new LinkedList<>();
        if(root==null) return res;
        deque.offer(root);
        while(!deque.isEmpty()){
            int len=deque.size();
            List<Integer> tmp=new LinkedList<>();
            //是大于不是大于等于
            while(len-->0){
                TreeNode cur=deque.peek();
                tmp.add(cur.val);
                if(cur.left!=null) deque.offer(cur.left);
                if(cur.right!=null) deque.offer(cur.right);
                deque.poll();
            }
            //头插
            res.add(0,tmp);
        }
        return res;
    }
}
