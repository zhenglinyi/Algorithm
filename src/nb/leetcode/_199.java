package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _199 {
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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        List<Integer> res=new LinkedList<>();
        if(root==null) return res;
        deque.offer(root);
        while(!deque.isEmpty()){
            int len=deque.size();

            //是大于不是大于等于
            while(len-->0){
                TreeNode cur=deque.peek();
                //只保存最后一个节点
                if(len==0)
                    res.add(cur.val);
                if(cur.left!=null) deque.offer(cur.left);
                if(cur.right!=null) deque.offer(cur.right);
                deque.poll();
            }
        }
        return res;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new LinkedList<>();
        Deque<TreeNode> deque=new LinkedList<>();
        if(root==null) return res;
        deque.offer(root);
        while(!deque.isEmpty()){
            int len=deque.size();
            while (len>0){
                TreeNode cur=deque.poll();
                if(len==1){
                    res.add(cur.val);
                }
                if(cur.left!=null) deque.offer(cur.left);
                if(cur.right!=null) deque.offer(cur.right);
                len--;

            }

        }
        return res;
    }
}