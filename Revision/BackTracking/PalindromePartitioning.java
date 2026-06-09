package Revision.BackTracking;

import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {
    static class Solution {

    public boolean isPalindrome(String str){
 
        int s = 0,e=str.length()-1;
        while(s < e){
           if(str.charAt(s) != str.charAt(e)) return false;
           s++;
           e--;
        }

        return true;
    }

    public void dfs(int start,String s,List<String> temp,List<List<String>> result){

        if(start == s.length()){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=start;i<s.length();i++){
            if(isPalindrome(s.substring(start,i+1))){
                temp.add(s.substring(start,i+1));
                dfs(i+1,s,temp,result);
                temp.remove(temp.size()-1);
            }
        }

    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        dfs(0,s,temp,result);
        return result;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        for(List<String> list : sol.partition("a")){
            System.out.println(list);
        }
    }
}
