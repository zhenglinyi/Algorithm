package nb.leetcode;

import java.util.PriorityQueue;

public class _23 {
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int listLen = lists.length;
        if (listLen == 0) return null;
        ListNode res = lists[0];
        if (listLen == 1) return res;

        for (int i = 1; i < lists.length; i++) {
            res = merge(res, lists[i]);
        }
        return res;
    }

    ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
            pre.next = null;
        }
        pre.next = list1 == null ? list2 : list1;
        return dummy.next;
    }
}
//小根堆
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        int listLen = lists.length;
        if (listLen == 0) return null;
        if (listLen == 1) return lists[1];
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>((o1, o2) -> o1.val-o2.val);
        for (int i = 0; i < lists.length; i++) {
            ListNode tmp=lists[i];
            while(tmp!=null) {
                minHeap.offer(tmp);
                tmp=tmp.next;
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode pre=dummy;
        while(!minHeap.isEmpty()){
            pre.next=minHeap.poll();
            pre=pre.next;
        }
        return dummy.next;
    }
}
