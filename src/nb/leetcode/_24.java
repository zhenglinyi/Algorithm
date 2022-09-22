package nb.leetcode;

public class _24 {
}
//迭代版本
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while(cur!=null&&cur.next!=null){
            ListNode tmp1=cur.next;
            ListNode tmp2=cur.next.next;
            cur.next.next=cur;
            cur.next=tmp2;
            pre.next=tmp1;
            pre=cur;
            cur=cur.next;
        }
        return dummy.next;
    }
}
//递归版本
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tmp=swapPairs(head.next.next);
        ListNode first=head;
        ListNode second=head.next;
        second.next=first;
        first.next=tmp;
        return second;

    }
}
