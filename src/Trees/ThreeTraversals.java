import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class ThreeTraversals {
    static class Solution {
        public void preOrderTraversal(TreeNode root){
            if(root==null) return;
            System.out.print(root.val+"  ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
        public void inOrderTraversal(TreeNode root){
            if(root==null) return;
            inOrderTraversal(root.left);
            System.out.print(root.val+"  ");
            inOrderTraversal(root.right);
        }
        public void postOrderTraversal(TreeNode root){
            if(root==null) return;
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val+"  ");
        }
        void dfs(TreeNode node, List<Integer> path) {
    if (node == null) return;

    // 👉 PICK (include node)
    path.add(node.val);

    // leaf node → print path
    if (node.left == null && node.right == null) {
        System.out.println(path);
    }

    // explore
    dfs(node.left, path);
    dfs(node.right, path);

    // backtrack
    path.remove(path.size() - 1);
}
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
        Integer[] treeAsArr = new Integer[]{1,-2,3};
        TreeNode root = buildTree(treeAsArr);
        printPrettyTree(root);
        sol.preOrderTraversal(root);
        System.out.println();
        sol.inOrderTraversal(root);
        System.out.println();
        sol.postOrderTraversal(root);
        System.out.println();
        sol.dfs(root,new ArrayList<>());
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
