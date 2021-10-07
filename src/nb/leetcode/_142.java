package nb.leetcode;

public class _142 {
}
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
//给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head,fast=head;
        ListNode index1;
        ListNode index2;
        while(true){
            if(fast==null||fast.next==null) return null;

            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                index1=fast;
                index2=head;
                break;
            }
        }
        while (index1!=index2){
            index1=index1.next;
            index2=index2.next;
        }
        return index1;
    }
}
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}


