package nb.jianzhi_offer;

public class jianzhi_18 {
}




//双指针
class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val==val)//特例
            return head.next;
        ListNode pre =head;
        ListNode cur=head.next;
        while(cur!=null&&cur.val!=val){
            pre=cur;
            cur=cur.next;
        }
        if(cur!=null)
            pre.next=cur.next;
        return head;
    }
}