package nb.leetcode;

public class _165 {
}

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] strs1=version1.split("\\.");
        String[] strs2=version2.split("\\.");
        int i = 0;
        for (; i < strs1.length||i < strs2.length; i++) {
            int a=i < strs1.length?Integer.valueOf(strs1[i]):0;
            int b=i < strs2.length?Integer.valueOf(strs2[i]):0;
            if(a>b){
                return 1;
            }else if(a<b){
                return -1;

            }
        }

        return 0;


    }
}

//双指针 优化空间复杂度
class Solution {
    public int compareVersion(String version1, String version2) {
        int n = version1.length(), m = version2.length();
        int i = 0, j = 0;
        while (i < n || j < m) {
            int x = 0;
            for (; i < n && version1.charAt(i) != '.'; ++i) {
                x = x * 10 + version1.charAt(i) - '0';
            }
            ++i; // 跳过点号
            int y = 0;
            for (; j < m && version2.charAt(j) != '.'; ++j) {
                y = y * 10 + version2.charAt(j) - '0';
            }
            ++j; // 跳过点号
            if (x != y) {
                return x > y ? 1 : -1;
            }
        }
        return 0;
    }
}

