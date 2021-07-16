package nb.jianzhi_offer;

public class jianzhi_24 {

}


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//自己写的
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode temp = head;
        return recur(temp);

    }

    public ListNode recur(ListNode temp) {
        ListNode res;
        if (temp.next.next != null) {
            res = recur(temp.next);//递归终止
        } else {
            res = temp.next;
        }
        temp.next.next = temp;
        temp.next = null;
        return res;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode res = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return res;
    }
}