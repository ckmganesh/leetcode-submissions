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
    public int rob(TreeNode root) {
         int[] a=robthis(root);
        return Math.max(a[0],a[1]);
        
    }
    public int[] robthis(TreeNode root)
    {int[] a=new int[2];
        if(root == null)
        {a[0]=0;a[1]=0;
            return a;}
        int[] left =robthis(root.left);
        int[] right=robthis(root.right);
        a[0]=left[1]+right[1]+root.val;
        a[1]=Math.max(left[0]+right[1],Math.max(left[1]+right[1],Math.max(left[1]+right[0],left[0]+right[0])));
     
        return a;
    }
}