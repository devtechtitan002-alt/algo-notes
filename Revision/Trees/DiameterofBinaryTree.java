package Revision.Trees;

public class DiameterofBinaryTree {

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
    public int[] diameterOfBT(TreeNode root){
       if(root==null) return new int[]{0,0};
       int[] left = diameterOfBT(root.left);
       int[] right = diameterOfBT(root.right);
       int pathLen = 1+Math.max(left[0],right[0]);
       int diameter = Math.max(left[0]+right[0],Math.max(left[1],right[1]));
       return new int[]{pathLen,diameter};
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterOfBT(root)[1];
    }

    }

}
