package nb.jianzhi_offer;

import java.util.LinkedList;
import java.util.Stack;

public class jianzhi_06 {
}







//栈
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public int[] reversePrint(ListNode head) {
        int[] res = {};
        if(head == null)
            return res;
        Stack<Integer> stack = new Stack<>();
        for(ListNode temp = head;temp != null;temp = temp.next){
            stack.push(temp.val);
        }
        res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.pop();
        return res;
    }
}

class Solution {
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }
}
