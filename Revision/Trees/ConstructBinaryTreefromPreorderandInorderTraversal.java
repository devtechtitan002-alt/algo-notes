package Revision.Trees;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    
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
    public TreeNode buildBT(int[] preorder,int[] inorder,int s,int e,int rIdx){
        if((!(s<e)) || rIdx>e) return null;
        TreeNode root = new TreeNode(preorder[rIdx]);
        for(int i=s;i<e;i++){
            if(inorder[i] == preorder[rIdx]){
                root.left = buildBT(preorder,inorder,0,i,rIdx+1);
                root.right = buildBT(preorder,inorder,i+1,e,rIdx+(e-s)+1);
            }
        }
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildBT(preorder,inorder,0,preorder.length,0);
    }
}

}
