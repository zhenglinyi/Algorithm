package nb.leetcode;

public class _21 {
}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode(-1);
        ListNode pre=dummy;
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                pre.next=list1;
                list1=list1.next;

            }else{
                pre.next=list2;
                list2=list2.next;
            }
            pre=pre.next;
            pre.next=null;
        }
        if(list1!=null){
            pre.next=list1;
        }
        if(list2!=null){
            pre.next=list2;
        }
        return dummy.next;
    }

}
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        return recur(list1,list2);
    }
    ListNode recur(ListNode list1, ListNode list2){
        if(list1==null){
            return list2;
        }
        if(list2==null) {
            return list1;
        }
        ListNode res;
        if(list1.val<list2.val){
            res=list1;
            res.next=recur(list1.next,list2);
        }else{
            res=list2;
            res.next=recur(list1,list2.next);
        }
        return res;

    }
}
