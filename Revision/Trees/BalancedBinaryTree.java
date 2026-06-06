package Revision.Trees;

public class BalancedBinaryTree {
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }

    class Solution {
    public int[] isBalancedTree(TreeNode root){
        if(root==null) return new int[]{1,0};
        int[] leftArr = isBalancedTree(root.left);
        int[] rightArr = isBalancedTree(root.right);
        int[] isBalanceVsHeight = new int[2];
        isBalanceVsHeight[1] = 1+Math.max(leftArr[1],rightArr[1]);
        isBalanceVsHeight[0] = Math.abs(leftArr[1]-rightArr[1]) <= 1 && (leftArr[0]==1 && rightArr[0]==1) ? 1 : 0;
        return isBalanceVsHeight;
    }
    public boolean isBalanced(TreeNode root) {
        return isBalancedTree(root)[0]==1;
    }
}
}
