package nb.leetcode;

public class _242 {
}

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record=new int[26];
        char[] S=s.toCharArray();
        for (char c : S) {
            record[c-'a']++;
        }
        char[] T=t.toCharArray();
        for (char c : T) {
            record[c-'a']--;
        }
        for (int i : record) {
            if(i!=0) return false;
        }
        return true;

    }
}
