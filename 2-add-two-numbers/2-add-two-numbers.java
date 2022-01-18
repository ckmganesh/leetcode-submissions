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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        int l1_val=0,l2_val=0,carry=0;
        ListNode l3 = dummy;
        while(l1!=null || l2!=null){
            if(l1==null) l1_val = 0;
            else{
                l1_val=l1.val;
                l1=l1.next;
            }
            if(l2==null){
                l2_val=0;
            }
            else{
                l2_val=l2.val;
                l2=l2.next;
            }
            int sum = l1_val+l2_val+carry;
            if(sum>=10){
                carry = sum/10;
            }
            else{
                carry=0;
            }
            ListNode  current=new ListNode(sum%10);
            l3.next=current;
            l3=l3.next;
        }
        if(carry>0){
            l3.next = new ListNode(carry);
            l3=l3.next;
        }
       
        return dummy.next;
    }
}