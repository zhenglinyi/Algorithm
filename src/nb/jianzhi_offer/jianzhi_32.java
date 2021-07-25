package nb.jianzhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class jianzhi_32 {
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
//BFS
class Solution {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> queue=new LinkedList<>();
        ArrayList<Integer> ans =new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node =queue.remove();
            ans.add(node.val);
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }

//        int[] res = new int[ans.size()];
//        for(int i = 0; i < ans.size(); i++)
//            res[i] = ans.get(i);
//        return res;

        //java中的流
        return ans.stream().mapToInt(i->i).toArray();
    }
}