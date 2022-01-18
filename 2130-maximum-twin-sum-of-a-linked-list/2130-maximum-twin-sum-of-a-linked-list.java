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
    ListNode temp;
    int max=0;
    public int pairSum(ListNode head) {
        temp=head;
        helper(head);
        return max;
    }
    void helper(ListNode node){
        if(node!=null){
            helper(node.next);
            max=Math.max(max,node.val+temp.val);
            temp=temp.next;
        }
    }
}