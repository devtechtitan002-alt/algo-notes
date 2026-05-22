package Revision.ArraysHashing;
import java.util.Set;
import java.util.HashSet;

public class ValidSudoku {
    static class Solution{
        public boolean isValidSudoku(char[][] board){

            // set for all row,cols,boxes
            Set<Character>[] rows = new HashSet[9];
            Set<Character>[] cols = new HashSet[9];
            Set<Character>[] boxes = new HashSet[9];

            //initializes set
            for(int i=0;i<9;i++){
                rows[i] = new HashSet<>();
                cols[i] = new HashSet<>();
                boxes[i] = new HashSet<>();
            }

            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){

                    char ch = board[i][j];
                    if(ch == '.') continue;

                    int box = ( (i/3)*3 ) + ( (j/3) );

                    if(rows[i].contains(ch) || cols[j].contains(ch) || boxes[box].contains(ch)) return false;

                    rows[i].add(ch);
                    cols[j].add(ch);
                    boxes[box].add(ch);

                }
            }

            return true;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        char[][] board = {
            {'5','3','.','.','7','.','.','.','.'}
           ,{'6','.','.','1','9','5','.','.','.'}
           ,{'.','9','8','.','.','.','.','6','.'}
           ,{'8','.','.','.','6','.','.','.','3'}
           ,{'4','.','.','8','.','3','.','.','1'}
           ,{'7','.','.','.','2','.','.','.','6'}
           ,{'.','6','.','.','.','.','2','8','.'}
           ,{'.','.','.','4','1','9','.','.','5'}
           ,{'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(sol.isValidSudoku(board));
    }
}
