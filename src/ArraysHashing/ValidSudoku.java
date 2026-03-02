package ArraysHashing;
import java.util.Set;
import java.util.HashSet;

public class ValidSudoku {
    static class Solution {
    public boolean isValidSudoku(char[][] board) {
    Set<Character>[] rowSet = new HashSet[9];
    Set<Character>[] colSet = new HashSet[9];
    Set<Character>[] boxSet = new HashSet[9];

    for (int i = 0; i < 9; i++) {
        rowSet[i] = new HashSet<>();
        colSet[i] = new HashSet<>();
        boxSet[i] = new HashSet<>();
    }

    for (int row = 0; row < 9; row++) {
        for (int col = 0; col < 9; col++) {

            char curr = board[row][col];

            if (curr == '.') continue;

            int boxIndex = (row / 3) * 3 + (col / 3);

            if (!rowSet[row].add(curr) || !colSet[col].add(curr) || !boxSet[boxIndex].add(curr)) {
                return false;
            }
        }
    }

    return true;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.isValidSudoku(new char[][]{}));
    }
}
}
