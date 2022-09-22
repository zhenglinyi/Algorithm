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

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record=new int[26];
        char[] sArr=s.toCharArray();
        char[] tArr=t.toCharArray();
        for (char c : sArr) {
            record[c-'a']++;
        }
        for (char c : tArr) {
            record[c-'a']--;
        }
        for (int r : record) {
            if(r!=0) return false;
        }
        return true;
    }
}
