package nb.leetcode;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class _429 {
}
//class Node {
//    public int val;
//    public List<Node> children;
//
//    public Node() {}
//
//    public Node(int _val) {
//        val = _val;
//    }
//
//    public Node(int _val, List<Node> _children) {
//        val = _val;
//        children = _children;
//    }
//};


class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> deque=new LinkedList<>();
        List<List<Integer>> res=new LinkedList<>();
        if(root==null) return res;
        deque.offer(root);
        while(!deque.isEmpty()){
            int len=deque.size();
            List<Integer> tmp=new LinkedList<>();
            //是大于不是大于等于
            while(len-->0){
                Node cur=deque.peek();
                tmp.add(cur.val);
                List<Node> children =cur.children;
                for (Node child : children) {
                    deque.offer(child);
                }
                deque.poll();
            }
            res.add(tmp);
        }
        return res;
    }
}