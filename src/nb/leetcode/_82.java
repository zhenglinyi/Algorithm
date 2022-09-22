package nb.leetcode;

public class _82 {
}
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode pre=dummy;
        ListNode cur=head;
        int tmp=101;
        while(cur.next!=null){
            if(tmp==cur.val){
                pre.next=cur.next;
                cur=pre.next;
            }
            else if(cur.val==cur.next.val){
                tmp=cur.val;
                pre.next=cur.next;
                cur=pre.next;

            }else{
                cur=cur.next;
                pre=pre.next;
            }
        }
        if(tmp==cur.val){
            pre.next=cur.next;
            cur=pre.next;
        }
        return dummy.next;


    }
}
//尾插法
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (head != null) {
            // 进入循环时，确保了 head 不会与上一节点相同
            if (head.next == null || head.val != head.next.val) {
                tail.next = head;
                tail = head;
            }
            // 如果 head 与下一节点相同，跳过相同节点
            while (head.next != null && head.val == head.next.val) head = head.next;
            head = head.next;
        }
        tail.next = null;
        return dummy.next;
    }
}