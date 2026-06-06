package Revision.Trees;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class KthSmallestElementinaBST {

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

    int count,ans;

    /*
    public void populateValueFromBST(TreeNode root){
        if(root == null) return;
        populateValueFromBST(root.left);
        list.add(root.val);
        populateValueFromBST(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        populateValueFromBST(root);
        //Collections.sort(list);
        return list.get(k-1);
    }
    */

    public void populateValueFromBST(TreeNode root){
        if(root == null || count == 0) return;
        populateValueFromBST(root.left);
        count -= 1;
        if(count == 0) {
            ans = root.val;
            return;
        }
        populateValueFromBST(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        populateValueFromBST(root);
        return ans;
    }

}
}
