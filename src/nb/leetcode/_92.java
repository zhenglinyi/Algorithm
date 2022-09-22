package nb.leetcode;

public class _92 {
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < left; i++) {
            pre = pre.next;
        }
        ListNode tmppre=pre;
        pre=pre.next;
        ListNode tmppre2=pre;
        ListNode cur=pre.next;
        for (int i = left; i < right; i++) {
            ListNode tmp=cur.next;
            cur.next=pre;
            //pre.next=null;
            pre=cur;
            cur=tmp;
        }
        tmppre.next=pre;
        tmppre2.next=cur;
        return dummy.next;
    }
}
//头插法
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode guard=dummy;

        for (int i = 1; i < left; i++) {
            guard=guard.next;
        }
        ListNode point=guard.next;
        for (int i = left; i < right ; i++) {
            ListNode remove=point.next;
            point.next=point.next.next;
            remove.next=guard.next;
            guard.next=remove;
//            ListNode tmp=guard.next;
//            guard.next=remove;
//            remove.next=tmp;
        }
        return dummy.next;
    }
}
