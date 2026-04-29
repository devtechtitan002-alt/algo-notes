package NumberTheory;

public class AddDigit {
    static class Solution {
    public int addDigits(int num) {
        if(num%10 == num) return num;

        while(num%10 != num){
            int curr = num;
            int sum = 0;
            while(curr != 0){
                sum += curr%10;
                curr /= 10;
            }
            num = sum;
        }
        return num;
    }

    /*
    public int addDigits(int num) {
    while (num >= 10) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        num = sum;
    }
    return num;
}
     */

     // return num == 0 ? 0 : 1 + (num - 1) % 9;  // O(1) time
}
}
