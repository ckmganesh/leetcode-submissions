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
    Random rand=null;
    ListNode head=null;
    public Solution(ListNode head) {
       rand = new Random();
        this.head=head;
    }
    
    public int getRandom() {
        int result=-1;
        ListNode node=head;
        for(int i=1;node!=null;i++){
            if(rand.nextInt(i)==i-1){
                result=node.val;
            }
            node=node.next;
        }
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */