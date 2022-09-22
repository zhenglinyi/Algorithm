package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _1047 {
}

class Solution {
    public String removeDuplicates(String s) {
        char[] sc=s.toCharArray();
        Deque<Character> deque=new LinkedList<>();
        for (int i = 0; i < sc.length; i++) {
            if(!deque.isEmpty()&&deque.peekLast()==sc[i]){
                deque.removeLast();
            }else{
                deque.offerLast(sc[i]);
            }
        }
        String str = "";
        //剩余的元素即为不重复的元素
        while (!deque.isEmpty()) {
            str = deque.removeLast() + str;
        }
        return str;
    }
}
