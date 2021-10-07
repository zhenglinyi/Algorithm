package nb.leetcode;

/**
 * @author shkstart
 * @date 2020-09-22 23:43
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
//迭代
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode temp=reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return temp;

    }
}

//递归
class Solution2 {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode temp = reverseList(head.next);//保存翻转以后的头结点
        head.next.next = head;
        head.next = null;
        return temp;
    }
}
public class _206 {
    public static void main(String[] args) {
        System.out.println("待遇性");
    }
}

