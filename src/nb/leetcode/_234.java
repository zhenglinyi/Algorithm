package nb.leetcode;

public class _234 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        //1.
        /*public boolean isPalindrome(ListNode head) {
            List<Integer> vals= new ArrayList<>();
            while(head!=null){
                vals.add(head.val);
                head=head.next;
            }
            int front=0;
            int back=vals.size()-1;
            while(front<back){
                if(!vals.get(front).equals(vals.get(back))){
                    return false;
                }
                front++;
                back--;
            }
            return true;
        }*/

        //2.
        /*private ListNode frontPointer;

        private boolean recursivelyCheck(ListNode currentNode){
            if(currentNode!=null){
                if(!recursivelyCheck(currentNode.next)){
                    return false;
                }
                if(currentNode.val!=frontPointer.val){
                    return false;
                }
                frontPointer=frontPointer.next;
            }
           return true;
        }
        public boolean isPalindrome(ListNode head) {
            frontPointer=head;
            return recursivelyCheck(head);
        }
    }*/
        //3.
        public boolean isPalindrome(ListNode head) {
            if(head==null){
                return true;
            }
            ListNode firstHalfEnd=endOfFirstHalf(head);
            ListNode secondHalfStart=reverseList(firstHalfEnd.next);

            // 判断是否回文
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // 还原链表并返回结果
//            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;
        }
        //链表反转
        private ListNode reverseList(ListNode head){
            ListNode prev=null;
            ListNode curr=head;
            while(curr!=null){
                ListNode nextTemp=curr.next;
                curr.next=prev;
                prev=curr;
                curr=nextTemp;
            }
            return prev;
        }
        private ListNode endOfFirstHalf(ListNode head){
            ListNode fast=head;
            ListNode slow=head;
            while(fast.next!=null&&fast.next.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow;
        }
    }
}
