package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class _20 {
}
class Solution {
    public boolean isValid(String s) {
        Deque<Character> deque=new LinkedList<>();
        char[] sc=s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            switch (sc[i]){
                case '(':
                case '{':
                case '[':
                    deque.push(sc[i]);
                    break;
                case ')':
                    if(deque.isEmpty()||deque.peek()!='('){
                        return false;
                    }else{
                        deque.pop();
                    }
                    break;
                case '}':
                    if(deque.isEmpty()||deque.peek()!='{'){
                        return false;
                    }else{
                        deque.pop();
                    }
                    break;
                case ']':
                    if(deque.isEmpty()||deque.peek()!='['){
                        return false;
                    }else{
                        deque.pop();
                    }
                    break;


            }

        }
        return deque.isEmpty();
    }
}