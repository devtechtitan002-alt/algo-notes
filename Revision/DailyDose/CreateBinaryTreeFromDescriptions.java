package Revision.DailyDose;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class CreateBinaryTreeFromDescriptions {
    static class Solution {

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

    public TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer,TreeNode> nodeMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int[] desc : descriptions){

            // parent part
            int parent = desc[0];

            // child part
            int child = desc[1];

            nodeMap.putIfAbsent(parent,new TreeNode(parent));
            nodeMap.putIfAbsent(child,new TreeNode(child));

            // final root finder
            set.add(parent);
            set.add(child);

        }

        int maxRank = 0;
        int maxRankVal = 0;

        for(int[] desc : descriptions){
            
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            if(isLeft == 1){
               nodeMap.get(parent).left = nodeMap.get(child);
            }else{
               nodeMap.get(parent).right = nodeMap.get(child);
            }

            if(set.contains(child)) set.remove(child);

        }


        /*

        TreeNode root = null;

        for(int isRoot : set){

             boolean isLeftMatch = false;
             boolean isRightMatch = false;


            for(int key : nodeMap.keySet()){

                if(nodeMap.get(key).left != null){
                    if(nodeMap.get(key).left.val == isRoot) isLeftMatch = true;
                }

                if(nodeMap.get(key).right != null){
                    if(nodeMap.get(key).right.val == isRoot) isRightMatch = true;
                }

            }

            if(!isLeftMatch && !isRightMatch){
                    root = nodeMap.get(isRoot);
            }

        }

        */

        return nodeMap.get(set.iterator().next());
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] description = {{39,70,1},{13,39,1},{85,74,1},{74,13,1},{38,82,1},{82,85,1}};  //{{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        sol.createBinaryTree(description);
    }
}  // [[39,70,1],[13,39,1],[85,74,1],[74,13,1],[38,82,1],[82,85,1]]
