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
  private int maxNum = Integer.MIN_VALUE; // 全局最大路径和

  public int maxPathSum(TreeNode root) {
      if (root == null) {
          return 0;
      }

      findMaxContribution(root);

      return maxNum;
  }

  // 寻找目标节点的最大贡献值
  // 最大贡献值：在以该节点为根节点的子树中，以该节点为起始点的最大路径和
  private int findMaxContribution(TreeNode node) {
      if (node == null) {
          return 0;
      }

      // 递归计算子节点的最大贡献值
      int leftMax = Math.max(0, findMaxContribution(node.left)); // 只接受>=0的贡献值，否则舍弃，确保路径和最大
      int rightMax = Math.max(0, findMaxContribution(node.right));

      // 计算全局最大路径和
      int newPathNum = leftMax + rightMax + node.val;
      maxNum = Math.max(newPathNum, maxNum);

      return Math.max(leftMax, rightMax) + node.val;
  }
}