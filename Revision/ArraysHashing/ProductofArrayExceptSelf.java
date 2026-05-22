package Revision.ArraysHashing;
import java.util.Arrays;
public class ProductofArrayExceptSelf {
    static class Solution{
        public int[] productExceptSelf(int[] nums){

            /*
            // result array
            int[] res = new int[nums.length];

            // left prefixProduct
            int leftPass = nums[0];
            res[0] = nums[0];

            for(int i=1;i<nums.length;i++){
                res[i] = nums[i]*leftPass;
                leftPass = res[i];
            }

            // right suffixProduct
            int rightPass = 1;
            for(int i=nums.length-1;i>0;i--){
                res[i] = res[i-1] * rightPass;
                rightPass *= nums[i];
            }

            res[0] = rightPass;

            return res;
            */


            // wihtout including current index 
            int[] res = new int[nums.length];

            // left pass
            int leftProduct = 1;
            for(int i=0;i<nums.length;i++){
                res[i] = leftProduct;
                leftProduct *= nums[i];
            }

            // right pass
            int rightProduct = 1;
            for(int i=nums.length-1;i>=0;i--){
                res[i] *= rightProduct;
                rightProduct *= nums[i]; 
            }

            return res;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1,2,3,4})));
    }
}
