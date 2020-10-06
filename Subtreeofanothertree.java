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
    public boolean isSubtree(TreeNode s, TreeNode t) {
   
     
        if(isidentical(s,t))
            return true;
        
        return s!=null && (isSubtree(s.left,t) || isSubtree(s.right,t));
        
    }
    public boolean isidentical(TreeNode s,TreeNode t)
    {
        if(s==null && t==null)
            return true;
        else if(s==null || t==null)
            return false;
        return s.val==t.val && isidentical(s.left,t.left) && isidentical(s.right,t.right);
    }
}