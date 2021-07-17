package nb.jianzhi_offer;

import java.util.HashMap;
import java.util.Map;

public class jianzhi_35 {
}



// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

//哈希表  遍历两遍
//利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，
// 再遍历构建新链表各节点的 next 和 random 引用指向即可。
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)//特例
            return null;
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        //复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while (cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        //构建新链表的 next 和 random 指向
        while (cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        //返回新链表的头节点
        return map.get(head);
    }
}



//拼接+拆分
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node cur = head;
        //复制各节点，并构建拼接链表
        while (cur != null) {
            Node temp = new Node(cur.val);
            temp.next = cur.next;
            cur.next = temp;
            cur = temp.next;
        }
        //构建各新节点的 random 指向
        cur = head;
        while (cur != null) {
            if (cur.random != null)
                cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        //拆分两链表
        cur = head;
        Node res = head.next;
        while (cur != null && cur.next.next != null) {
            Node temp = cur.next.next;
            cur.next.next = cur.next.next.next;
            cur.next = temp;
            cur = temp;
        }
        cur.next = null;
        //cur.next.next = null;
        return res;

        /*//原作者的双指针
        cur = head.next;
        Node pre = head, res = head.next;
        while(cur.next != null) {
            pre.next = pre.next.next;
            cur.next = cur.next.next;
            pre = pre.next;
            cur = cur.next;
        }
        pre.next = null; // 单独处理原链表尾节点
        return res;      // 返回新链表头节点*/


    }
}