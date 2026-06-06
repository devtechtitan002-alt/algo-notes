package Revision.Trees;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTreeLevelOrderTraversal {
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
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){

            int levelSize = q.size();

            List<Integer> list = new ArrayList<>();

            for(int i=0;i<levelSize;i++){

                TreeNode curr = q.poll();

                list.add(curr.val);

                if(curr.left != null) q.add(curr.left);

                if(curr.right != null) q.add(curr.right);

            }

            result.add(list);

        }
        
        return result;
    }
}
}
