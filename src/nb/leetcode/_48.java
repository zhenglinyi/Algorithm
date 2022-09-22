package nb.leetcode;

public class _48 {
}
class Solution {
    public void rotate(int[][] matrix) {
        int m=matrix.length;
        for(int i=0;i<m;i++){
            //注意j要从i开始，否则相当于反转了两遍
            for(int j=i;j<m;j++){
                int tmp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=tmp;
            }
        }
        for(int i=0;i<m;i++){
            reverse(matrix[i]);
        }

    }
    public static void reverse(int[] line){
        int i=0;
        int j=line.length-1;
        while(i<j){
            int tmp=line[i];
            line[i]=line[j];
            line[j]=tmp;
            i++;
            j--;
        }
    }
}