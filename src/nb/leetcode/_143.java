package nb.leetcode;

public class _143 {
}


class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null || head.next == null) return;
        ListNode end = head;
        ListNode start = head;
        int length = 1;
        //找到结尾节点
        while (end.next != null) {
            end = end.next;
            length++;
        }
        int startNum = length / 2 + 1;
        //找到需要开始反转的第一个节点
        for (int i = 1; i < startNum; i++) {
            start = start.next;
        }
        //反转从需要反转的第一个节点到结尾节点的所有节点
        reverse(start, null);
        ListNode left = head;
        ListNode right = end;
        //两种情况分别对应奇数偶数的情况
        while (left != right && left.next != right) {
            ListNode left_nxt = left.next;
            ListNode right_nxt = right.next;
            //左边的节点指向最右的节点
            left.next = right;
            //右边节点指向左后节点
            right.next = left_nxt;
            //左后移，右前移
            left = left_nxt;
            right = right_nxt;
        }


    }
    //反转从a到b之间的节点
    void reverse(ListNode a, ListNode b) {
        ListNode pre = null;
        ListNode cur = a;
        ListNode nxt = a;
        while (cur != b) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
    }
}