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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxPath;
    }

    public int maxNode(TreeNode node){
        if(node == null) return 0 ;
        int max = node.val;
        int leftMax = Integer.MIN_VALUE;
        int rightMax = Integer.MIN_VALUE;
        if(node.left!=null){
         leftMax = maxNode(node.left);
        }
        if(node.right!=null){
            rightMax = maxNode(node.right);
        }
        if(leftMax == Integer.MIN_VALUE && rightMax == Integer.MIN_VALUE) return max;
        return max+Math.max(Math.max(leftMax,rightMax),0); 
    }

    public void  maxPath(TreeNode node){
        int left = Math.max(maxNode(node.left),0);
        int right = Math.max(maxNode(node.right),0);
        maxPath = Math.max(node.val+left+right,maxPath);
        if(node.left!=null){
            maxPath(node.left);
        }
        if(node.right!=null){
            maxPath(node.right);
        }

    }
}
