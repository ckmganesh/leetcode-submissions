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
    class NodeComparator implements Comparator<ListNode>{
        public int compare(ListNode a,ListNode b){
            return a.val-b.val;
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue(new NodeComparator());
        for(ListNode l:lists){
            if(l!=null){
                queue.add(l);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while(!queue.isEmpty()){
            ListNode current = queue.poll();
            head.next=current;
            head=head.next;
            if(current.next!=null) queue.add(current.next);
        }
        return dummy.next;
    }
}