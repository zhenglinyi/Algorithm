package nb.jianzhi_offer;

class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0|| matrix[0].length == 0){
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int i = 0;
        int j = cols -1;
        while(i < rows && j >= 0){
            int temp = matrix[i][j];
            //左边的数小 下边的数大
            if(temp > target){
                j--;
            }else if(temp < target){
                i++;
            }else{
                return true;
            }
        }
        return false;
    }
}
public class jianzhi_04 {
}
