package Revision.Trees;

public class BinaryTreeMaximumPathSum {

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


    static class Solution {

    int VSum = Integer.MIN_VALUE;

    public int maxPathSumDFS(TreeNode root){
         if(root == null) return 0;
         int left = Math.max(0,maxPathSumDFS(root.left));
         int right = Math.max(0,maxPathSumDFS(root.right));
         int vSum = left + root.val + right;
         VSum = Math.max(vSum , VSum);
         return root.val + Math.max(left,right);
    }

    public int maxPathSum(TreeNode root) {
        maxPathSumDFS(root);
        return VSum;
    }
}
}
