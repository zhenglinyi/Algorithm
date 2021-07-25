package nb.jianzhi_offer;

public class jianzhi_33 {
}


//递归分治
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder,0,postorder.length-1);
    }
    boolean recur(int[] postorder,int i,int j){
        //终止条件
        // 当 i≥j ，说明此子树节点数量≤1 ，无需判别正确性，因此直接返回true
        if(i>=j) return true;
        int p=i;
        //划分左右子树
        while(postorder[p]<postorder[j]) p++;
        int m=p;//第一个大于根节点的节点，记为m
        while(postorder[p]>postorder[j]) p++;
        //p==j 判断是否为二叉搜索树，判断右子树的正确性
        return p==j&&recur(postorder,i,m-1)&&recur(postorder,m,j-1);
    }
}