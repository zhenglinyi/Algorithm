package nb.leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _103 {
}
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        Deque<TreeNode> deque=new LinkedList<>();
        boolean ltor=true;
        deque.offerLast(root);
        while(!deque.isEmpty()){
            LinkedList<Integer> tmp=new LinkedList<>();
            int len=deque.size();
            //从左到右
            if(ltor){
                while(len-->0){
                    TreeNode tmpNode=deque.pollFirst();
                    tmp.add(tmpNode.val);
                    if(tmpNode.left!=null) deque.offerLast(tmpNode.left);
                    if(tmpNode.right!=null) deque.offerLast(tmpNode.right);
                }
                //从右到左
            }else{
                while(len-->0){
                    TreeNode tmpNode=deque.pollLast();
                    tmp.add(tmpNode.val);
                    if(tmpNode.right!=null) deque.offerFirst(tmpNode.right);
                    if(tmpNode.left!=null) deque.offerFirst(tmpNode.left);

                }
            }
            ltor=!ltor;
            res.add(new ArrayList<>(tmp));
        }
        return res;

    }
}