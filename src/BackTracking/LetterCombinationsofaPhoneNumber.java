import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class LetterCombinationsofaPhoneNumber {
    static class Solution {
    public void letterCombination(String s,StringBuilder sb,int start,Map<Character,String> map,List<String> res){
        if(start==s.length()){
             res.add(sb.toString());
             return;
        }
        String digit = map.get(s.charAt(start));
        for(int i=0;i<digit.length();i++){
            sb.append(digit.charAt(i));
            letterCombination(s,sb,start+1,map,res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        StringBuilder sb = new StringBuilder();
        letterCombination(digits,sb,0,map,res);
        return res;
    }
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("234"));
    }
}
