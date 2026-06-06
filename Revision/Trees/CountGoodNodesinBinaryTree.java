package Revision.Trees;

public class CountGoodNodesinBinaryTree {
    static class Solution {

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

    public int goodNodes(TreeNode root,int goodVal){
        if(root == null) return 0;
        
        int valToPass = goodVal <= root.val ? root.val : goodVal;

        int left = goodNodes(root.left,valToPass);
        int right = goodNodes(root.right,valToPass);

        return goodVal <= root.val ? 1+left+right : left+right;
    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root,root.val);
    }
    }

}
