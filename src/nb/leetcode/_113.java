package nb.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class _113 {
}

class Solution {
    List<List<Integer>> res=new ArrayList<>();
    List<Integer> tmp =new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        recur(root,targetSum);
        return res;
    }
    public void recur(TreeNode root, int targetSum){
        if(root==null) return;
        tmp.add(root.val);
        if(root.left==null&&root.right==null){
            if(root.val==targetSum)
                //深拷贝一份，操
                res.add(new LinkedList<>(tmp));
        }
        recur(root.left,targetSum-root.val);
        recur(root.right,targetSum-root.val);
        tmp.remove(tmp.size()-1);
    }

}
