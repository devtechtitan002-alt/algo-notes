package PractiseSets;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
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

    static class Solution{
        public List<Integer> rightSideView(TreeNode root){
            if(root == null) return null;

            List<Integer> res = new ArrayList<>();

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while(!q.isEmpty()){

                int level = q.size();

                for(int i=0;i<level;i++){

                    TreeNode curr = q.poll();

                    if(i==0) res.add(curr.val);

                    if(curr.right!=null) q.add(curr.right);

                    if(curr.left!=null) q.add(curr.left);
                }
            }

            return res;
        }
    }

}
