package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _637 {
}
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        List<Double> res=new LinkedList<>();
        if(root==null) return res;
        deque.offer(root);
        while(!deque.isEmpty()){
            int len=deque.size();

            int l=len;
            long sum=0;
            //是大于不是大于等于
            while(l-->0){
                TreeNode cur=deque.peek();
                sum+=cur.val;
                if(cur.left!=null) deque.offer(cur.left);
                if(cur.right!=null) deque.offer(cur.right);
                deque.poll();
            }
            double mean=sum*1.0/len;
            res.add(mean);
        }
        return res;
    }
}