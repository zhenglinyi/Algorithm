package nb.jianzhi_offer;

/**
 * @author shkstart
 * @date 2021-07-21 9:51
 */
public class jianzhi_36 {
}

// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
//本文解法基于性质：二叉搜索树的中序遍历为 递增序列 。
class Solution {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        dfs(root);
        head.left = pre;
        pre.right = head;//进行头节点和尾节点的相互指向，这两句的顺序也是可以颠倒的
        return head;
    }

    public void dfs(Node cur) {
        if (cur == null)
            return;
        dfs(cur.left);

        //pre用于记录双向链表中位于cur左侧的节点，即上一次迭代中的cur,当pre==null时，cur左侧没有节点,即此时cur为双向链表中的头节点
        //反之，pre!=null时，cur左侧存在节点pre，需要进行pre.right=cur的操作。
        if (pre != null)
            pre.right = cur;
        else
            head = cur;
        cur.left = pre;//pre是否为null对这句没有影响,且这句放在上面两句if else之前也是可以的。
        pre = cur;//pre指向当前的cur
        dfs(cur.right);//全部迭代完成后，pre指向双向链表中的尾节点
    }
}

class Solution {
    Node pre, head;

    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        dfs(root);
        head.left=pre;
        pre.right=head;
        return head;


    }

    public void dfs(Node cur) {
        if(cur==null) return;
        dfs(cur.left);
        if(pre==null) head=cur;
        else pre.right=cur;
        cur.left=pre;
        pre=cur;
        dfs(cur.right);
    }
}
