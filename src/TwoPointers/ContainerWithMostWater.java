public class ContainerWithMostWater {
    static class Solution {
    public int maxArea(int[] height) {
        int left=0,right=height.length-1,maxArea=0,currArea=0;
        while(left<right){
           currArea = Math.min(height[left],height[right]) * (right-left);
           maxArea = Math.max(currArea,maxArea);
           if(height[left]<height[right]){
            left++;
           }else{
            right--;
           }
        }
        return maxArea;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
}
