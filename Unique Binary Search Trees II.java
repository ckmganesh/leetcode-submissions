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
    public List<TreeNode> generateTrees(int n) {
        if(n<1)
            return new ArrayList<TreeNode>();
        return help(1,n);
        
    }
    List<TreeNode> help(int start,int end)
    {
         List<TreeNode> result=new ArrayList<>();
        if(start>end)
        {
            result.add(null);
            return result;
        }
        for(int i=start;i<=end;i++)
        {
            List<TreeNode> left=help(start,i-1);
            List<TreeNode> right=help(i+1,end);
            for(TreeNode l:left)
            {
                for(TreeNode r: right)
                {
                    TreeNode n=new TreeNode(i);
                    n.left=l;
                    n.right=r;
                    result.add(n);
                }
            }

        }
        return result;
    }
    
}