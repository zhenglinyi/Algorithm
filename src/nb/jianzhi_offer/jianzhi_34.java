package nb.jianzhi_offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class jianzhi_34 {
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
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//自己写的递归，很烂
class Solution {
    List<List<Integer>> res;
    LinkedList<Integer> temp;
    int sum=0;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        res=new LinkedList<>();
        temp=new LinkedList<>();
        recur(root,target);
        return res;
    }
    void recur(TreeNode cur, int target){
        if(cur==null) {
            return;
        }
        int val=cur.val;
        sum+=val;
        temp.addLast(val);
        if(cur.left==null&&cur.right==null){
            if(sum==target){
                LinkedList<Integer> t =new LinkedList<>(temp);
                res.add(t);
            }
        }
        recur(cur.left,target);
        recur(cur.right,target);
        sum-=val;
        temp.removeLast();
    }
}

//k神的解
class Solution {
    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    //tar很灵性
    void recur(TreeNode root, int tar) {
        if(root == null) return;
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null)
            res.add(new LinkedList(path));
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }
}

