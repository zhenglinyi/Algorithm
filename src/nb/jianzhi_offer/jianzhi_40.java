package nb.jianzhi_offer;

import java.util.Arrays;

public class jianzhi_40 {
}


//快速排序
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);//取前k个元素

    }

    //选一个基准，左边的都小于基准，右边的都大于基准，然后递归
    private void quickSort(int[] arr, int l, int r) {
        // 子数组长度为 1 时终止递归
        if (l >= r)
            return;
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l])
                j--;
            while (i < j && arr[i] <= arr[l])
                i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);

    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

//基于快速排序的数组划分
//根据快速排序原理，如果某次哨兵划分后 基准数正好是第k+1 小的数字 ，
// 那么此时基准数左边的所有数字便是题目所求的 最小的 k 个数 。
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1, k);
        return Arrays.copyOf(arr, k);//取前k个元素

    }

    //选一个基准，左边的都小于基准，右边的都大于基准，然后递归
    private void quickSort(int[] arr, int l, int r, int k) {
        // 子数组长度为 1 时终止递归
        if (l >= r)
            return;
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l])
                j--;
            while (i < j && arr[i] <= arr[l])
                i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) {
            quickSort(arr, l, i - 1, k);
        }
        if (i < k) {
            quickSort(arr, i + 1, r, k);
        }
        return;


    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}


class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k >= arr.length) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }
    private int[] quickSort(int[] arr, int k, int l, int r) {
        int i = l, j = r;
        while (i < j) {
            while (i < j && arr[j] >= arr[l]) j--;
            while (i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if (i > k) return quickSort(arr, k, l, i - 1);
        if (i < k) return quickSort(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}


