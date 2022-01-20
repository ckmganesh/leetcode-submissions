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
    public int countNodes(TreeNode root) {
        int leftDepth=leftDepth(root);
        int rightDepth = rightDepth(root);
        if(leftDepth==rightDepth) return (1<<leftDepth)-1;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    int leftDepth(TreeNode root){
        int height=0;
        while(root!=null){
            root=root.left;
            height++;
        }
        return height;
    }
    int rightDepth(TreeNode root){
        int height=0;
        while(root!=null){
            root=root.right;
            height++;
        }
        return height;
    }
}