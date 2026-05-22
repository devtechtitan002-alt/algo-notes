package Revision.TwoPointers;

public class TrappingRainWater {
   static class Solution {
    public int trap(int[] height) {

        int left=0,right=height.length-1,lm=height[left],rm=height[right];
        int waterUnits = 0;

        while(left<right){

            // when left boundary less than right boundry then no longer its been useful for trap water as les boundary spills water so once anyone side boundary less , get units of water possible to trap then move that side pointer

           if( lm <= rm ){
               if( lm > height[left] ) waterUnits += lm-height[left];
               left++;
               lm = Math.max(lm,height[left]);
           }else{
               if( rm > height[right] ) waterUnits += rm-height[right];
               right--;
               rm = Math.max(rm,height[right]); 
           }


        }
        return waterUnits;
    }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.trap(new int[]{3,2,1}));
    }
}
