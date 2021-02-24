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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> right_side = new ArrayList<Integer>();
         helper(root,right_side,0);
        return right_side;
        
    }
    
    void helper(TreeNode root,List<Integer> right_side,int h)
    {
        if(root==null)
            return ;
        if(right_side.size()<=h)
        {
            right_side.add(root.val);
        }
        helper(root.right,right_side,h+1);
        helper(root.left,right_side,h+1);
    }
}