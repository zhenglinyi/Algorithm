package nb.leetcode;

import java.util.LinkedList;
import java.util.List;

public class _6 {
}

class Solution {
    public String convert(String s, int numRows) {
        List<StringBuilder> rows=new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i=0;int flag=-1;
        for (char c : s.toCharArray()) {
            if(i==0||i==numRows-1) flag=-flag;
            rows.get(i).append(c);
            i+=flag;
        }
        StringBuilder res=new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }
}
