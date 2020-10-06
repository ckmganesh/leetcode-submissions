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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> result=new ArrayList();
            if(root==null)
        {
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty())
    {
        int size=queue.size();
        List<Integer> current=new ArrayList();
        for(int i=0;i<size;i++)
        {
            
            TreeNode currentnode=queue.remove();
            
            current.add(currentnode.val);
            
            if(currentnode.left != null)
            {
                queue.add(currentnode.left);
            }
             if(currentnode.right != null)
            {
                queue.add(currentnode.right);
            }
            
        }
        result.add(current);
        
    }
        Collections.reverse(result);
    return result;
    
        
    }
}
    
