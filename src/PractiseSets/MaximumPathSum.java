package PractiseSets;

public class MaximumPathSum {

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


    static class Solution{
        public int maxPathSum(TreeNode root,int[] max){
           if(root == null) return 0;

            // handled negatives results by left / right subtree
            int left = Math.max(0,maxPathSum(root.left,max));
            int right = Math.max(0,maxPathSum(root.right,max));

            // V-shape sum
            max[0] = Math.max(max[0] , left+root.val+right);

            return root.val+ Math.max(left,right);

        }
        public int maxPathSum(TreeNode root){
            int[] max = new int[]{Integer.MIN_VALUE};
            maxPathSum(root,max);
            return max[0];
        }
    }


}
