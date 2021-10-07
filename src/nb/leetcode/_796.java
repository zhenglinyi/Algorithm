package nb.leetcode;

public class _796 {
}

//由于 A + A 包含了所有可以通过旋转操作从 A 得到的字符串，因此我们只需要判断 B 是否为 A + A 的子串即可。
class Solution {
    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}

class Solution {
    public boolean rotateString(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        if (A.equals(B)) {
            return true;
        }
        for (int i = 1; i < A.length(); i++) {
            if (B.startsWith(A.substring(i)) && B.endsWith(A.substring(0, i))) {
                return true;
            }
        }
        return false;
    }
}



