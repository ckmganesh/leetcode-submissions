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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start=new StringBuilder();
        StringBuilder dest = new StringBuilder();
        getPath(root,startValue,start);
        getPath(root,destValue,dest);
        start=start.reverse();
        dest=dest.reverse();
        int i=0;
        while(i<start.length() && i<dest.length() && start.charAt(i)==dest.charAt(i)) i++;
        StringBuilder result = new StringBuilder();
        for(int j=i;j<start.length();j++) result.append("U");
        for(int j=i;j<dest.length();j++)result.append(dest.charAt(j));
        return result.toString();
    }
    boolean getPath(TreeNode root,int target,StringBuilder path){
        if(root==null) return false;
        if(root.val==target) return true;
        if(getPath(root.left,target,path)) path.append("L");
        else if(getPath(root.right,target,path)) path.append("R");
        return path.length()>0;
    }
}