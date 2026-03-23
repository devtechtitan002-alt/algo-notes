import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class InvertBinaryTree {
    static class Solution {
    public TreeNode invertTree(TreeNode root) {
        /*
        if(root==null || ( root.left==null && root.right==null )) return root;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
        */
        if(root==null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode curr = root;
        q.add(curr);
        
        while(!q.isEmpty()){
            TreeNode currRoot = q.poll();

            TreeNode leftNode = currRoot.left;
            TreeNode rightNode = currRoot.right;

            if(leftNode!=null){ q.add(leftNode); }

            if(rightNode!=null){ q.add(rightNode); }

            // inversion
            TreeNode temp = currRoot.left;
            currRoot.left = currRoot.right;
            currRoot.right = temp;
            
        }
        return root;
        /*
        if (root == null) return null;

Queue<TreeNode> q = new LinkedList<>();
q.add(root);

while (!q.isEmpty()) {
    TreeNode node = q.poll();

    // swap
    TreeNode temp = node.left;
    node.left = node.right;
    node.right = temp;

    if (node.left != null) q.add(node.left);
    if (node.right != null) q.add(node.right);
}

return root;
 */
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
        Integer[] treeAsArr = new Integer[]{4,2,7,1,3,6,9};
        TreeNode root = buildTree(treeAsArr);
        printPrettyTree(root);
        printPrettyTree(sol.invertTree(root));
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
