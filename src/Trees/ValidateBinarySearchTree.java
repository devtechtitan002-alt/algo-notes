import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ValidateBinarySearchTree {
    static class Solution {
        Integer prev = null;

public boolean isValidBSTree(TreeNode root){
    if(root == null) return true;

    if(!isValidBSTree(root.left)) return false;

    if(prev != null && root.val <= prev) return false;

    prev = root.val;   // 🔥 always update

    return isValidBSTree(root.right);
}

public boolean isValidBST(TreeNode root) {
    return isValidBSTree(root);
}
        /*
        public boolean isValidBSTree(TreeNode root,int min,int max) {
            if(root == null) return true;
            boolean leftTree = isValidBSTree(root.left,min,root.val);
            boolean rightTree = isValidBSTree(root.right,root.val,max);
            return  min < root.val && root.val < max && leftTree && rightTree;
        }
        public boolean isValidBST(TreeNode root) {
            if(root == null ) return false;
            return isValidBSTree(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        */
        /*
        boolean isValidBSTree(TreeNode root, long min, long max) {
          if (root == null) return true;

          if (!(min < root.val && root.val < max)) return false;

          return isValidBSTree(root.left, min, root.val) && isValidBSTree(root.right, root.val, max);
        }
        public boolean isValidBST(TreeNode root) {
           return isValidBSTree(root, Long.MIN_VALUE, Long.MAX_VALUE);
         }
        */
    }
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

    public static void main(String[] args){
        Solution sol = new Solution();
        Integer[] treeAsArr = new Integer[]{0,-1};
        TreeNode root = buildTree(treeAsArr);
        printPrettyTree(root);
        System.out.println(sol.isValidBST(root));
    }


    // build tree
    public static TreeNode buildTree(Integer[] arr) {
    if (arr == null || arr.length == 0) return null;

    TreeNode root = new TreeNode(arr[0]);
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    int i = 1;

    while (!queue.isEmpty() && i < arr.length) {
        TreeNode curr = queue.poll();

        // left
        if (i < arr.length && arr[i] != null) {
            curr.left = new TreeNode(arr[i]);
            queue.add(curr.left);
        }
        i++;

        // right
        if (i < arr.length && arr[i] != null) {
            curr.right = new TreeNode(arr[i]);
            queue.add(curr.right);
        }
        i++;
    }

    return root;
    }

    //pretty print tree
    public static void printPrettyTree(TreeNode root) {
    int height = getHeight(root);
    int width = (int) Math.pow(2, height) * 2;

    List<List<String>> res = new ArrayList<>();
    for (int i = 0; i < height * 2; i++) {
        List<String> row = new ArrayList<>(Collections.nCopies(width, " "));
        res.add(row);
    }

    fillTree(res, root, 0, width / 2, height);

    // print
    for (List<String> row : res) {
        for (String s : row) {
            System.out.print(s);
        }
        System.out.println();
    }
}

private static void fillTree(List<List<String>> res, TreeNode node, int row, int col, int height) {
    if (node == null) return;

    res.get(row).set(col, String.valueOf(node.val));

    int gap = (int) Math.pow(2, height - row / 2 - 2);

    if (node.left != null) {
        res.get(row + 1).set(col - gap, "/");
        fillTree(res, node.left, row + 2, col - gap * 2, height);
    }

    if (node.right != null) {
        res.get(row + 1).set(col + gap, "\\");
        fillTree(res, node.right, row + 2, col + gap * 2, height);
    }
}

private static int getHeight(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(getHeight(root.left), getHeight(root.right));
}
}
