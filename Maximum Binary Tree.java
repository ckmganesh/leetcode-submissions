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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildtree(0,nums.length-1,nums);
    }
    
    TreeNode buildtree(int l,int r,int nums[])
    {
        if(l>r){ return null;}
        if(l==r){return new TreeNode(nums[l]);}
        int index=l,max=nums[l];
        for(int i=l;i<=r;i++)
        {
            if(nums[i]>max)
            {
                max=nums[i];
                index=i;
                
            }
        }
        TreeNode n=new TreeNode(nums[index]);
        n.left= buildtree(l,index-1,nums);
        n.right=buildtree(index+1,r,nums);
        return n;
    }
}