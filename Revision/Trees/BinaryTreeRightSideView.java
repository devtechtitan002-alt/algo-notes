package Revision.Trees;

import java.util.List;
import java.util.ArrayList;

public class BinaryTreeRightSideView {

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

    public void rightSideViewDFS(TreeNode root,int level,List<Integer> res){
        if(root == null) return;

        if(level == res.size()) res.add(root.val);

        rightSideViewDFS(root.right,level+1,res);
        rightSideViewDFS(root.left,level+1,res);

    }
    public List<Integer> rightSideView(TreeNode root) {
         List<Integer> result = new ArrayList<>();
         rightSideViewDFS(root,0,result);
         return result;
    }

}
}
