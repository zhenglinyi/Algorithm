package nb.leetcode;

public class _108 {
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums,0,nums.length-1);
    }

    public TreeNode recur(int[] nums,int left,int right){
        if(left>right) return null;
        int mid=left+((right-left)>>1);
        TreeNode root=new TreeNode(nums[mid]);
        root.left=recur(nums,left,mid-1);
        root.right=recur(nums,mid+1,right);
        return root;
    }

}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return recur(nums,0,nums.length-1);
    }
    TreeNode recur(int[] nums,int left,int right){
        if(right>left) return null;
        int mid=left+((right-left)>>1);
        TreeNode root=new TreeNode(nums[mid]);
        root.left=recur(nums,left,mid-1);
        root.right=recur(nums,mid+1,right);
        return root;
    }
}
