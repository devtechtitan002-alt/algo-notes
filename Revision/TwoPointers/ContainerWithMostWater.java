package Revision.TwoPointers;

public class ContainerWithMostWater {
    static class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1,maxArea=0;
        while(left < right){
            int b = ( right - left );
            int l = Math.min(height[left],height[right]);  // min height is threshold for water within container
            maxArea = Math.max(maxArea,l*b);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxArea;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxArea(new int[]{1,1}));
    }
}
