import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    static public class Solution{

        boolean isPalindrome(String s, int l, int r){
    while(l < r){
        if(s.charAt(l++) != s.charAt(r--)) return false;
    }
    return true;
}
        public List<List<String>> partition(String s) {
    List<List<String>> res = new ArrayList<>();
    backtrack(s, 0, new ArrayList<>(), res);
    return res;
}

public void backtrack(String s, int start,
                      List<String> curr,
                      List<List<String>> res) {

    if(start == s.length()){
        res.add(new ArrayList<>(curr));
        return;
    }

    for(int end = start; end < s.length(); end++){

        if(isPalindrome(s, start, end)){

            curr.add(s.substring(start, end + 1)); // CHOOSE

            backtrack(s, end + 1, curr, res);      // EXPLORE

            curr.remove(curr.size() - 1);          // UNDO
        }
    }
}
    }
}
