package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _513 {
}


class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque=new LinkedList<>();
        deque.offer(root);
        int res=0;
        while(!deque.isEmpty()){
            int len=deque.size();
            for (int i = 0; i < len; i++) {
                TreeNode tmpNode=deque.peek();
                if(i==0) res=tmpNode.val;
                if(tmpNode.left!=null) deque.offer(tmpNode.left);
                if(tmpNode.right!=null) deque.offer(tmpNode.right);
                deque.poll();
            }
        }
        return res;

    }
}

// 递归法
class Solution {
    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root,0);
        return value;
    }

    private void findLeftValue (TreeNode root,int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            if (deep > Deep) {
                value = root.val;
                Deep = deep;
            }
        }
        if (root.left != null) findLeftValue(root.left,deep + 1);
        if (root.right != null) findLeftValue(root.right,deep + 1);
    }
}