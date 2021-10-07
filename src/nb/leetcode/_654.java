package nb.leetcode;

public class _654 {
}

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums,0,nums.length);
    }
    public TreeNode construct(int[] nums,int left,int right){
        if(left==right) return null;
//        if (right - left == 1) {// 只有一个元素
//            return new TreeNode(nums[left]);
//        }
        //寻找最大值
        int maxIndex=left;
        int max=nums[left];
        for (int i = left+1; i < right; i++) {
            if(max<nums[i]){
                maxIndex=i;
                max=nums[i];
            }
        }
        TreeNode root=new TreeNode(max);
        root.left=construct(nums,left,maxIndex);
        root.right=construct(nums,maxIndex+1,right);
        return root;
    }
}
