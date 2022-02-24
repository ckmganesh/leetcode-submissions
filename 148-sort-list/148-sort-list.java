/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode l1 = head;
        ListNode slow = head;
        ListNode fast= head;
        while(fast!=null && fast.next!=null){
            l1=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        l1.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);
        return merge(left,right);
    }
    public ListNode merge(ListNode l1,ListNode l2){
        
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        ListNode current =null;
        while(l2!=null && l1!=null){
            if(l1.val<l2.val){
                current = new ListNode(l1.val);
                l1=l1.next;
               
            }
            else{
                 current = new ListNode(l2.val);
                l2=l2.next;
            }
             l3.next=current;
             l3=l3.next;
        }
        while(l1!=null){
            current = new ListNode(l1.val);
            l1=l1.next;
            l3.next=current;
            l3=l3.next;
        }
         while(l2!=null){
            current = new ListNode(l2.val);
            l2=l2.next;
            l3.next=current;
            l3=l3.next;
        }
        return dummy.next;
    }
}