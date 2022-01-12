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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        TreeNode current = root;
        while(true){
            if(current.val<=val){
                if(current.right!=null) current=current.right;
                else{
                    current.right=new TreeNode(val);
                    break;
                }
            }
            else{
                if(current.left!=null) current=current.left;
                else{
                    current.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}