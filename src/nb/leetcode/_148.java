package nb.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _148 {
}

class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fast = head.next;
        //偶数的话找到中间的左节点，奇数的话找到中间节点
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (left != null || right != null) {
            if (left == null) {
                cur.next = right;
                right = right.next;
            } else if (right == null) {
                cur.next = left;
                left = left.next;
            } else if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }
            cur = cur.next;

        }
        return dummy.next;


    }
}


class Solution {
    /**
     * 要求：给你链表的头结点head，请将其按 升序 排列并返回 排序后的链表 。
     * 进阶：你可以在O(nlogn) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
     *
     * @param head
     * @return 方法：自底向上直接合并的的归并排序
     */
    public ListNode sortList(ListNode head) {
        // 归并的步长
        int intv = 1;
        // 链表长度
        int len = 0;
        // 归并的两个前后模块，遍历指针，辅助头结点
        ListNode h1, h2, pre, res;
        res = new ListNode(0);
        res.next = head;
        // 遍历链表
        ListNode h = head;
        // 获得链表长度
        while (h != null) {
            h = h.next;
            len++;
        }
        // 自底向上进行归并排序
        while (intv < len) {
            pre = res;
            h = res.next;
            while (h != null) {
                int i = intv;
                h1 = h;
                // 遍历得到h1
                while (i > 0 && h != null) {
                    i--;
                    h = h.next;
                }
                // 如果i>0，则说明只有h1，没有后续的h2了
                if (i > 0) {
                    break;
                }
                // 重新更新i的值
                i = intv;
                h2 = h;
                // 获得h2部分的长度，有可能长度不到intv
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                // 分别得到h1部分和h2部分的长度
                int c1 = intv;
                int c2 = intv - i;
                // 对h1和h2进行排序
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    // 更新pre的值，这个值为已排序链表的指针
                    pre = pre.next;
                }
                // 其中一个为0，另一个不为0时，链接剩下的链表
                pre.next = c1 == 0 ? h2 : h1;
                // 更新pre指针的位置
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                // 链接余下的链表，在下一次循环时，可能会直接break（h1的长度小于intv），不进行h1和h2归并（数量不够），这里就是为了将余下的链表连接起来。
                // 因为一次intv对应的一次循环，pre指针一定是从开始一直到结尾，整个链表的的长度不能变，如果缺少这一步，最后一部分h1会丢失
                pre.next = h;
            }
            // 更新归并的步长
            intv *= 2;
        }
        return res.next;
    }
}

//快速排序
class Solution {
    public ListNode sortList(ListNode head) {
        return quickSortLinkedList(head)[0];
    }

    public ListNode[] quickSortLinkedList(ListNode head) {
        if(head == null || head.next == null) return new ListNode[]{head,head};
        //pivot为head，定义跟踪分割左右两个链表的头尾指针
        ListNode p = head.next,headSmall= new ListNode(),headBig = new ListNode(),tailSmall = headSmall, tailBig = headBig;

        //partition操作，以pivot为枢纽分割为两个链表
        while(p != null){
            if(p.val < head.val){
                tailSmall.next = p;
                tailSmall = tailSmall.next;
            }else{
                tailBig.next = p;
                tailBig = tailBig.next;
            }
            p = p.next;
        }

        //断开<pivot的排序链表、pivot、>=pivot的排序链表，链表变为三个部分
        head.next = null;
        tailSmall.next = null;
        tailBig.next = null;

        //递归partition
        ListNode[] left = quickSortLinkedList(headSmall.next);
        ListNode[] right = quickSortLinkedList(headBig.next);


        //如果有<pivot的排序链表、连接pivot
        if(left[1] != null) {
            left[1].next = head;
        }
        //连接pivot、>=pivot的排序链表
        head.next = right[0];

        //确定排序后的头节点和尾节点
        ListNode newHead,newTail;
        if(left[0] != null) newHead = left[0];
        else newHead = head;
        if(right[1] != null) newTail = right[1];
        else newTail = head;

        //返回当前层递归排序好的链表头节点和尾节点
        return new ListNode[]{newHead,newTail};
    }


}

//优先队列
class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        while (head != null){
            queue.add(head);
            head = head.next;
        }
        ListNode ans = new ListNode(queue.poll().val);
        ListNode temp = ans;
        while (!queue.isEmpty()){
            temp.next = new ListNode(queue.poll().val);
            temp = temp.next;
        }
        return ans;
    }
}


