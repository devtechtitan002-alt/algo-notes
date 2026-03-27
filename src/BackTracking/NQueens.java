import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class NQueens {
    static class Solution {
    public void solvedNQueens(boolean[] d1,boolean[] d2,boolean[] rook,int row,int size,List<String> curr,List<List<String>> res){
            
        if( row == size ){
            res.add(new ArrayList<>(curr));
            return;
        }
        
        for(int j=0;j<size;j++){

            if(!rook[j] && !d1[(row-j)+(size-1)] && !d2[row+j]){

                rook[j]=true;
                d1[(row-j)+(size-1)]=true;
                d2[row+j]=true;
                StringBuilder sb = new StringBuilder();
                for(int k=0;k<size;k++){
                    if(k==j) sb.append("Q");
                    else sb.append(".");
                }
                curr.add(sb.toString());

                solvedNQueens(d1,d2,rook,row+1,size,curr,res);

                rook[j]=false;
                d1[(row-j)+(size-1)]=false;
                d2[row+j]=false;
                curr.remove(curr.size()-1);

            }

        }

    }
    public List<List<String>> solveNQueens(int n) {
        boolean[] rook = new boolean[n];
        boolean[] d1 = new boolean[2*n-1];
        boolean[] d2 = new boolean[2*n-1];
        List<List<String>> res = new ArrayList<>();
        List<String> queenPlaces = new ArrayList<>();
        solvedNQueens(d1,d2,rook,0,n,queenPlaces,res);
        return res;
    }
}
    
    

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<String> list : sol.solveNQueens(4)){
            System.out.println(list);
        }
    }
}
