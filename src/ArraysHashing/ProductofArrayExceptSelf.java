import java.util.Arrays;

class ProductofArrayExceptSelf{
   static class Solution{
    public int[] productExceptSelf(int[] nums) {
        int leftProduct = nums[0];
        int[] result = new int[nums.length];
        result[0] = leftProduct;
        for(int i=1;i<nums.length;i++){
           result[i] = leftProduct;
           leftProduct *= nums[i];
        }
        int rightProduct=1;
        for(int i=result.length-1;i>=0;i--){
            result[i] = rightProduct*result[i];
            rightProduct *= nums[i];
        }
        return result;
    }
   }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.productExceptSelf(new int[]{1,2,3,4})));
    }
}