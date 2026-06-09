package Revision.BackTracking;

import java.util.List;
import java.util.ArrayList;

public class LetterCombinationsofaPhoneNumber {
    static class Solution {

    public void dfs(int idx,String[] map,String digits,StringBuilder sb,List<String> result){
         
        if(idx == digits.length()){
            result.add(sb.toString());
            return;
        }


        for(char ch : map[digits.charAt(idx)-'0'].toCharArray()){

            sb.append(ch);
            dfs(idx+1,map,digits,sb,result);
            sb.deleteCharAt(sb.length()-1);

        }
    
    }

    public List<String> letterCombinations(String digits) {

        String[] map = new String[10];
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";

        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfs(0,map,digits,sb,result);
        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23"));
    }
}
