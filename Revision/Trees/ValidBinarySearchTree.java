package Revision.Trees;

public class ValidBinarySearchTree {
    
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

    public boolean isValidBSTree(TreeNode root,Long min,Long max){
        if(root == null) return true;

        if(min < root.val && root.val < max){
            return isValidBSTree(root.left,min,(long)root.val) && isValidBSTree(root.right,(long)root.val,max);
        }

        return false;
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTree(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    /*
    public boolean isValidBSTree(TreeNode root, long min, long max) {
    if(root == null) return true;

    if(root.val <= min || root.val >= max) {
        return false;
    }

    return isValidBSTree(root.left, min, root.val)
        && isValidBSTree(root.right, root.val, max);
}
         */

    }

}
