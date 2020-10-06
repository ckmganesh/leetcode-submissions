/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        
        List <List <Integer>> lists = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        boolean isRev = false;
        while( !queue.isEmpty() ){
            int size = queue.size();
            LinkedList<Integer> list = new LinkedList<>();
            for(int i =0;i<size;i++){
                TreeNode n = queue.poll();
                if(isRev == false)
                    list.add(n.val);
                else
                    list.addFirst(n.val);
                if(n.left!=null) queue.add(n.left);
                if(n.right!=null) queue.add(n.right);
            }
            isRev =!isRev;
            lists.add(list);
        }
            
        return lists;
            
            
        
    }
}