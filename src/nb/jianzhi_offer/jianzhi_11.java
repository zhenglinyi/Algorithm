package nb.jianzhi_offer;












//二分查找
class Solution {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        if(right == 0){
            return numbers[0];
        }
        while(left!=right){
            int mid = left + (right - left) / 2;
            //中间值大于最右边的值，说明分界点肯定再mid的右边
            if(numbers[mid] > numbers[right]){
                left = mid + 1;
                //中间值小于右边的值，说明分界点可能是mid也可能在mid左边
            }else if(numbers[mid] < numbers[right]){
                right = mid;
                //mid和right相等说明有重复元素，暴力缩小范围
            }else if(numbers[mid] == numbers[right]){
                right--;
            }
        }
        return numbers[left];
    }
}
public class jianzhi_11 {
    
}
