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
    int height(TreeNode root)
    {
        if(root==null)
            return 0;
        int left=height(root.left);
        int right=height(root.right);
        return Math.max(left,right)+1;
    }
    public int deepestLeavesSum(TreeNode root) {
        Queue <TreeNode> queue =new LinkedList();
        queue.add(root);int sum=0;
        int size=0;
        while(!queue.isEmpty())
        {
            size=queue.size();  
            sum=0;
                for(int i=0;i<size;i++)
                {
                     TreeNode temp=queue.remove();
                    sum+=temp.val;
                     if(temp.left!=null)
                queue.add(temp.left);
            if(temp.right!=null)
                queue.add(temp.right);
            }
                }
            
           
        return sum;
        }
    
        
    }
