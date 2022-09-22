package nb.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class _671 {
}
class Solution {
    TreeSet<Integer> set = new TreeSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (set.size() < 2) return -1;
        //TreeSet取第一个
        int second = set.pollFirst();
        second = set.pollFirst();

        return second;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

class Solution {
    Set<Integer> set = new HashSet<>();
    public int findSecondMinimumValue(TreeNode root) {
        dfs(root);
        if (set.size() < 2) return -1;
        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (int i : set) {
            if (i <= first) {
                second = first;
                first = i;
            } else if (i <= second) {
                second = i;
            }
        }
        return second;
    }
    void dfs(TreeNode root) {
        if (root == null) return;
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

作者：AC_OIer
        链接：https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/solution/gong-shui-san-xie-yi-ti-shuang-jie-shu-d-eupu/
        来源：力扣（LeetCode）
        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

class Solution {
    int ans=-1;
    int rootval;
    public int findSecondMinimumValue(TreeNode root) {
        rootval=root.val;
        dfs(root);
        return ans;

    }
    void dfs(TreeNode root){
        if(root==null) return;
        if(ans!=-1&&root.val>=ans){
            return;
        }
        if(root.val>rootval){
            ans=root.val;
        }
        dfs(root.left);
        dfs(root.right);

    }
}

