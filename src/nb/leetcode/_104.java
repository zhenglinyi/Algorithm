package nb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _104 {
}

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)   return 0;
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;
        while (!que.isEmpty())
        {
            int len = que.size();
            while (len > 0)
            {
                TreeNode node = que.poll();
                if (node.left != null)  que.offer(node.left);
                if (node.right != null) que.offer(node.right);
                len--;
            }
            depth++;
        }
        return depth;
    }
}

class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;

        if(root.left==null)
            return maxDepth(root.right)+1;
        if(root.right==null)
            return maxDepth(root.left)+1;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
