package nb.leetcode;

import java.util.Arrays;

public class _300 {
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        //到第几个数为止最长的长度
        int[] dp=new int[nums.length];
        //都初始化为1
        Arrays.fill(dp,1);
        //记录最终结果
        int res=1;
        //两次for循环扫一遍
        for (int i = 1; i <nums.length; i++) {
            for (int j = 0; j <i; j++) {
                if(nums[i]>nums[j]){
                    //和他前面每个数都做比较，dp取最大的
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            //更新
            res=Math.max(res,dp[i]);
        }
        return res;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int res = 0;
        for(int num : nums) {
            int i = 0, j = res;
            while(i < j) {
                int m = (i + j) / 2;
                if(tails[m] < num) i = m + 1;
                else j = m;
            }
            tails[i] = num;
            if(res == j) res++;
        }
        return res;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tail=new int[nums.length];
        int res=0;
        for (int num : nums) {
            int left=0;
            int right=res;
            while(left<right){
                int mid=left+(right-left)/2;
                if(tail[mid]>=num){
                    right=mid;
                }else{
                    left=mid+1;
                }
            }
            tail[left]=num;
            if(res==right) res++;
        }
        return res;
    }
}
//有点难
class Solution {
    public int lengthOfLIS(int[] nums) {
        /** 二分查找 */
        // 维护一个 cell 数组（递增），遍历 nums;
        // 若当前元素 num 比 cell 中最后一个元素大，则直接将其插入 cell;
        // 否则，将 cell 中比 num 大的第一个元素替换为 num
        int size = nums.length;
        if (size < 2) return size;
        int[] arr = new int[size];
        arr[0] = nums[0];
        int res = 1; // arr数组中实际存入的值的数量，即递增子序列的长度
        for (int i = 1; i < size; i++) {
            // 若当前元素 num 比 cell 中最后一个元素大
            if (nums[i] > arr[res - 1]) {
                arr[res] = nums[i];
                res++;
                continue;
            }
            // 否则，二分查找 cell 中比 num 大的第一个元素
            int left = 0, right = res - 1, mid;
            while (left <= right) {
                mid = left + (right - left) / 2;
                // left指针最终指向的就是比 num 大的第一个元素
                if (arr[mid] >= nums[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            arr[left] = nums[i];
        }
        return res;
    }
}
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] tail=new int[nums.length];
        tail[0]=nums[0];
        int res=0;
        int L=0;
        for (int i = 0; i < nums.length; i++) {
            int left=0;
            int right=res;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(tail[mid]>=nums[i]){
                    right=mid-1;
                    L=right;
                }else{
                    left=mid+1;
                }
            }
            tail[L]=nums[i];
            if(res==L) res++;
        }
        return res;
    }
}
public class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        // tail 数组的定义：长度为 i + 1 的上升子序列的末尾最小是几
        int[] tail = new int[len];
        // 遍历第 1 个数，直接放在有序数组 tail 的开头
        tail[0] = nums[0];
        // end 表示有序数组 tail 的最后一个已经赋值元素的索引
        int end = 0;

        for (int i = 1; i < len; i++) {
            // 【逻辑 1】比 tail 数组实际有效的末尾的那个元素还大
            if (nums[i] > tail[end]) {
                // 直接添加在那个元素的后面，所以 end 先加 1
                end++;
                tail[end] = nums[i];
            } else {
                // 使用二分查找法，在有序数组 tail 中
                // 找到第 1 个大于等于 nums[i] 的元素，尝试让那个元素更小
                int left = 0;
                int right = end;
                while (left < right) {
                    // 选左中位数不是偶然，而是有原因的，原因请见 LeetCode 第 35 题题解
                    // int mid = left + (right - left) / 2;
                    int mid = left + ((right - left) >>> 1);
                    if (tail[mid] < nums[i]) {
                        // 中位数肯定不是要找的数，把它写在分支的前面
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                // 走到这里是因为 【逻辑 1】 的反面，因此一定能找到第 1 个大于等于 nums[i] 的元素
                // 因此，无需再单独判断
                tail[left] = nums[i];
            }
            // 调试方法
            // printArray(nums[i], tail);
        }
        // 此时 end 是有序数组 tail 最后一个元素的索引
        // 题目要求返回的是长度，因此 +1 后返回
        end++;
        return end;
    }


}
