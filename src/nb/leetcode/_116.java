package nb.leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _116 {
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;
    public Node() {}

    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
class Solution {
    public Node connect(Node root) {
        Deque<Node> deque = new LinkedList<>();
        if (root == null) return root;
        deque.offer(root);
        while(!deque.isEmpty()){
            int len=deque.size();

            while(len>0){
                Node cur=deque.poll();
                if(cur.left!=null) deque.offer(cur.left);
                if(cur.right!=null) deque.offer(cur.right);
                if(len==1){
                    cur.next=null;
                }else{
                    cur.next=deque.peek();
                }

                len--;
            }

        }
        return root;
    }
}
class Solution {
    public Node connect(Node root) {
        Deque<Node> deque=new LinkedList<>();
        if(root==null) return root;
        deque.offer(root);
        while(!deque.isEmpty()){
            int len=deque.size();
            //是大于不是大于等于
            while(len-->0){
                Node cur=deque.poll();
                if(len==0) cur.next=null;
                else cur.next=deque.peek();
                if(cur.left!=null) deque.offer(cur.left);
                if(cur.right!=null) deque.offer(cur.right);
            }
        }
        return root;
    }
}

class Solution {
    public Node connect(Node root) {
        Queue<Node> tmpQueue = new LinkedList<Node>();
        if (root != null) tmpQueue.add(root);

        while (tmpQueue.size() != 0){
            int size = tmpQueue.size();

            Node cur = tmpQueue.poll();
            if (cur.left != null) tmpQueue.add(cur.left);
            if (cur.right != null) tmpQueue.add(cur.right);

            for (int index = 1; index < size; index++){
                Node next = tmpQueue.poll();
                if (next.left != null) tmpQueue.add(next.left);
                if (next.right != null) tmpQueue.add(next.right);

                cur.next = next;
                cur = next;
            }
        }

        return root;
    }
}