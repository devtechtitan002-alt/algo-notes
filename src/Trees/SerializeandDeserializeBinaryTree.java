import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Arrays;
public class SerializeandDeserializeBinaryTree {
    static public class Codec {

    // Encodes a tree to a single string.  
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return sb.append("1").toString();
        q.add(root);
        sb.append("0").append(root.val);
        int levelLength = 0;
        while(!q.isEmpty()){
           levelLength = q.size();
           sb.append("-");
           for(int i=0;i<levelLength;i++){
              TreeNode currRoot = q.poll();
              if(currRoot == null) continue;
              if(currRoot.left==null){ 
                  sb.append("1");
                  q.add(null); 
               }else{
                 q.add(currRoot.left);
                 sb.append("0").append(currRoot.left.val);
               }
               sb.append(".");
              if(currRoot.right==null){ 
                  sb.append("1");
                  q.add(null); 
               }else{
                 q.add(currRoot.right);
                 sb.append("0").append(currRoot.right.val);
               }
               if( i < levelLength - 1 ) {
                  sb.append(".");
               }
           }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("1")) return null;

    Queue<TreeNode> q = new LinkedList<>();
    String[] levels = data.split("-");

    TreeNode root = new TreeNode(Integer.parseInt(levels[0].substring(1)));
    q.add(root);

    for(int i = 1; i < levels.length; i++){
        String[] nodes = levels[i].split("\\.");

        for(int j = 0; j < nodes.length; j += 2){
    TreeNode parent = q.poll();

    // LEFT
    String leftNode = nodes[j];
    TreeNode left = leftNode.charAt(0) == '1' ? null : new TreeNode(Integer.parseInt(leftNode.substring(1)));

    if(parent != null){
        parent.left = left;
    }
    q.add(left);

    // RIGHT
    String rightNode = nodes[j+1];
    TreeNode right = rightNode.charAt(0) == '1' ? null : new TreeNode(Integer.parseInt(rightNode.substring(1)));

    if(parent != null){
        parent.right = right;
    }
    q.add(right);
}
    }
    return root;
    }
    }
    /*
    public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                sb.append("null,");
                continue;
            }

            sb.append(curr.val).append(",");
            q.add(curr.left);
            q.add(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) return null;

        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty()) {
            TreeNode parent = q.poll();

            // LEFT
            if (!nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = left;
                q.add(left);
            }
            i++;

            // RIGHT
            if (!nodes[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = right;
                q.add(right);
            }
            i++;
        }

        return root;
    }
}
     */
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
        Codec ser = new Codec();
        Codec dser = new Codec();
        Integer[] treeAsArr = new Integer[]{4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2};
        TreeNode root = buildTree(treeAsArr);
        printPrettyTree(root);
        String serialisedString = ser.serialize(root);
        System.out.println(serialisedString);
        printPrettyTree(dser.deserialize(serialisedString));
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
