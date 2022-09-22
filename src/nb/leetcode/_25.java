package nb.leetcode;

public class _25 {
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummpy =new ListNode(-1);
        dummpy.next=head;
        ListNode end=dummpy;
        ListNode pre=dummpy;
        ListNode cur=head;
        while(end!=null) {
            //找到结尾节点
            for (int i = 0; i < k && end!= null; i++) {
                end = end.next;
            }
            //说明不够k个
            if(end==null) break;

            ListNode nxt_end = end.next;
            ListNode nxt_pre = cur;
            end.next = null;
            pre.next = reverse(cur);
            pre=nxt_pre;
            cur=nxt_end;
            pre.next=cur;
            end=pre;
        }
        return dummpy.next;

    }
    ListNode reverse(ListNode start){
        ListNode pre=null;
        ListNode cur=start;
        while(cur!=null){
            ListNode nxt=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nxt;
        }
        return pre;
    }
//    ListNode reverse(ListNode pre,ListNode cur){
//        pre.next=null;
//        while(cur!=null){
//            ListNode tmp=cur.next;
//            cur.next=pre;
//            pre=cur;
//            cur=tmp;
//        }
//        return pre;
//    }

}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) end = end.next;
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}



class Solution {
    ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a, b;
        a = b = head;
        for (int i = 0; i < k; i++) {
            // 不足 k 个，不需要反转，base case
            if (b == null) return head;
            b = b.next;
        }
        // 反转前 k 个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }
    /** 反转区间 [a, b) 的元素，注意是左闭右开 */
    ListNode reverse(ListNode a, ListNode b) {
        ListNode pre, cur, nxt;
        pre = null; cur = a; nxt = a;
        // while 终止的条件改一下就行了
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 返回反转后的头结点
        return pre;
    }

}
