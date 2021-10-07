package nb.leetcode;

import java.util.*;

public class _515 {
}
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        List<Integer> res=new LinkedList<>();
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
            res.add(Collections.max(tmp));
        }
        return res;
    }
}