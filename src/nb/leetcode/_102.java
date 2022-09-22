package nb.leetcode;

import javax.imageio.event.IIOReadProgressListener;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _102 {
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
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
            res.add(tmp);
        }
        return res;
    }
}

class Solution {
    List<List<Integer>> resL;
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return resL;
        resL=new LinkedList<>();
        traverse(root,1);
        return resL;
    }
    void traverse(TreeNode root,int deep){

        if(resL.size()<deep){
            resL.add(new LinkedList<Integer>());
        }
        resL.get(deep-1).add(root.val);

        if(root.left!=null) traverse(root.left,deep+1);
        if(root.right!=null) traverse(root.right,deep+1);
    }


}
