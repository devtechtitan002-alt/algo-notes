package Revision.BackTracking;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    static class Solution {

    public String getQueenPosString(int i,int n){
        StringBuilder sb = new StringBuilder();

        for(int j=0;j<n;j++){
            if(j==i){
                sb.append("Q");
            }else{
                sb.append(".");
            }
        }

        return sb.toString();
    }

    public void dfs(int n,int row,List<String> temp, List<List<String>> result,boolean[] rook,boolean[] bL,boolean[] bR){
        
        if( row >= n ){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<n;i++){

            if(rook[i]) continue;

            if(bL[(row+i)] || bR[n-(i-row)]) continue;

            rook[i] = true;

            bL[(row+i)] = true;
            bR[n-(i-row)] = true;

            temp.add(getQueenPosString(i,n));

            dfs(n,row+1,temp,result,rook,bL,bR);

            temp.remove(temp.size()-1);

            bR[n-(i-row)] = false;
            bL[(row+i)] = false;

            rook[i] = false;

        }

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();

        boolean[] rook = new boolean[n];
        boolean[] bisL = new boolean[2*n+1];
        boolean[] bisR = new boolean[2*n+1];

        Arrays.fill(rook,false);
        Arrays.fill(bisL,false);
        Arrays.fill(bisR,false);

        dfs(n,0,temp,result,rook,bisL,bisR);
        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<String> list : sol.solveNQueens(4)){
            System.out.println(list);
        }
    }
}
