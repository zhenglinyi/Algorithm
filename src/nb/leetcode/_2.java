package nb.leetcode;

public class _2 {
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre=new ListNode(-1);
        ListNode cur=pre;
        int carry=0;
        while(l1!=null||l2!=null){
            int num1=l1==null?0:l1.val;
            int num2=l2==null?0:l2.val;
            int sum=num1+num2+carry;
            carry=sum/10;
            int num=sum%10;
            cur.next=new ListNode(num);
            cur=cur.next;
            l1=l1!=null? l1.next:l1;
            l2=l2!=null? l2.next:l2;

        }
        if(carry==1)
            cur.next=new ListNode(1);
        return pre.next;

    }
}
