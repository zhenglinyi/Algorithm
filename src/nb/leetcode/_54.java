package nb.leetcode;

import java.util.LinkedList;
import java.util.List;

public class _54 {
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int l=0,r=matrix[0].length-1,t=0,b=matrix.length-1;
        int size=matrix.length*matrix[0].length;
        List<Integer> res=new LinkedList<>();
        while (res.size()!=size){
            for (int i = l; i <= r&&res.size()!=size; i++) {
                res.add(matrix[t][i]);
            }
            t++;
            for (int i = t; i <= b&&res.size()!=size; i++) {
                res.add(matrix[i][r]);
            }
            r--;
            for (int i = r; i >=l&&res.size()!=size ; i--) {
                res.add(matrix[b][i]);
            }
            b--;
            for (int i = b; i >=t&&res.size()!=size ; i--) {
                res.add(matrix[i][l]);
            }
            l++;
        }
        return res;

    }
}

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> result = new LinkedList<>();
        if(matrix==null||matrix.length==0) return result;
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        int numEle = matrix.length * matrix[0].length;
        while (numEle >= 1) {
            for (int i = left; i <= right && numEle >= 1; i++) {
                result.add(matrix[top][i]);
                numEle--;
            }
            top++;
            for (int i = top; i <= bottom && numEle >= 1; i++) {
                result.add(matrix[i][right]);
                numEle--;
            }
            right--;
            for (int i = right; i >= left && numEle >= 1; i--) {
                result.add(matrix[bottom][i]);
                numEle--;
            }
            bottom--;
            for (int i = bottom; i >= top && numEle >= 1; i--) {
                result.add(matrix[i][left]);
                numEle--;
            }
            left++;
        }
        return result;

    }
}
