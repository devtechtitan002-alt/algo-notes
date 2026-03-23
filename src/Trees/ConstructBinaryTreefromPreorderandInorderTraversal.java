import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
    static class Solution {
    int[] preIdx = {0};
    Map<Integer, Integer> inorderMap = new HashMap<>();
    /*
    public int getRootIndex(int[] preorder,int[] inorder,int lb,int rb){
    if(lb > rb || preIdx[0] >= preorder.length ) return -1;

    int rootVal = preorder[preIdx[0]];

    for(int i = lb; i <= rb; i++){
        if(rootVal == inorder[i]) {
            preIdx[0]++;
            return i;
        }
    }
    return -1;
    }
    */
    public TreeNode buildTreeBST(int[] preorder,int[] inorder,int leftBoundary,int rightBoundary){
        if( leftBoundary > rightBoundary ) return null;
        int rootIdx = inorderMap.get(preorder[preIdx[0]++]); //getRootIndex(preorder,inorder,leftBoundary,rightBoundary);
        if(rootIdx == -1) return null;
        TreeNode root = new TreeNode(inorder[rootIdx]);

        root.left = buildTreeBST(preorder,inorder,leftBoundary,rootIdx-1);
        root.right = buildTreeBST(preorder,inorder,rootIdx+1,rightBoundary);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < inorder.length; i++){
           inorderMap.put(inorder[i], i); // value → index
        }
        return buildTreeBST(preorder,inorder,0,inorder.length-1);
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
        int[] preorder = new int[]{8,4,2,6,12,10,14};
        int[] inorder = new int[]{2,4,6,8,10,12,14};
        printPrettyTree(sol.buildTree(preorder,inorder));
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
