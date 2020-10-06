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
    int ans=0;
    HashSet<TreeNode> covered=new HashSet();
    public int minCameraCover(TreeNode root) {
        covered.add(null);
        dfs(root,null);
        return ans;
    }
    public void dfs(TreeNode root,TreeNode  par)
    {
        if(root!=null)
        {
            dfs(root.left,root);
            dfs(root.right,root);
            if((par==null && !covered.contains(root)) || !covered.contains(root.right) || !covered.contains(root.left))
            {
                ans++;
                covered.add(par);
                covered.add(root);
                covered.add(root.right);
                covered.add(root.left);
            }
        }
    }
}