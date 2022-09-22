package nb.buchong;

//寻找最右边界
public class _木头切割问题_二分法 {
    class Solution {
        public int cutWood(int[] nums, int k) {
            // 找到最大长度的木头
            int maxLen = 0;
            for (int i = 0; i < nums.length; i++) {
                maxLen = Math.max(maxLen, nums[i]);
            }
            int left = 1, right = maxLen+1;
            while (left < right) {
                int mid = left + right >> 1;
                // 以 mid 长度截取木头, 查找能截取的最多段
                int cnt = 0;
                for (int i = 0; i < nums.length; i++) {
                    cnt += nums[i] / mid;
                }
                // 如果能截出 k段以上, 则更新结果
                if (cnt >= k) {
                    left = mid + 1;

                } else {
                    right = mid;
                }
            }
            return left-1 ;
        }
    }

//    public static void main(String[] args) {
//        Solution solution = new Main().new Solution();
//        int[] nums = {4, 7, 2, 10, 5};
//        System.out.println(solution.cutWood(nums, 5));
//    }
}
