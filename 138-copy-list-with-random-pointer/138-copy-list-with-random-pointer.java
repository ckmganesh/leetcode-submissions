/*
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
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node current=head;
        HashMap<Node,Node> map = new HashMap();
        map.put(null,null);
        while(current!=null){
            Node copy = new Node(current.val);
            map.put(current,copy);
            current=current.next;
        }
        System.out.println(map);
        current=head;
        while(current!=null){
            Node copy = map.get(current);
            copy.next=map.get(current.next);
            copy.random=map.get(current.random);
            current=current.next;
        }
        return map.get(head);
    }
}