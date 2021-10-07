package nb.leetcode;

public class _459 {
}
//两个字符串连接，去掉第一个和最后一个元素后还包含本身，则证明true
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 1).contains(s);
    }
}


