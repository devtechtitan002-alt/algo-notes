package NumberTheory;

import PractiseSets.ReorderList.ListNode;

public class CountPrimes {
    static class Solution{
        public boolean isPrime(int n){
            for(int i=2;i<=n/2;i++){
                if(n%i == 0) return false;
            }
            return true;
        }
        public int countPrimes(int n) {

           int primes = 0;

           if(n<2) return primes;

           for(int i=2;i<=n;i++){
              if(isPrime(i)) primes++;
           }

           return primes;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.countPrimes(10));
    }
}
