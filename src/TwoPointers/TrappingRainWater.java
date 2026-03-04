import java.util.Arrays;
public class TrappingRainWater {
      static class Solution{
         public int trap(int[] height) {
           int storedUnits=0;
           int[] minHeightArr = new int[height.length];
           int[] maxHeightArr = new int[height.length];
           minHeightArr[0]=height[0];
           for(int i=1;i<height.length;i++){
             minHeightArr[i] = Math.max(height[i],minHeightArr[i-1]);
           }
           maxHeightArr[height.length-1]=height[height.length-1];
           for(int i=height.length-2;i>=0;i--){
             maxHeightArr[i] = Math.max(height[i],maxHeightArr[i+1]);
           }
           for(int i=1;i<height.length;i++){
             int trappedWaterVol = Math.min(minHeightArr[i],maxHeightArr[i])-height[i];
             if(trappedWaterVol>0){ storedUnits += trappedWaterVol;}
           }
           return storedUnits;
           /*
           int n = height.length;
        int lm=0, rm=0 , l=0 , r=n-1;
        int water=0;
        while(l<=r){
            if(height[l]>height[r]){
                if(height[r]>rm){
                    rm = height[r];
                }else{
                    water+=rm-height[r];
                }
                r--;
            }else{
                if(height[l]>lm){
                    lm = height[l];
                }else{
                    water+=lm-height[l];
                }
                l++;
            }
        }
        return water;
         */
        }
     }
    
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        System.out.println(sol.trap(new int[]{4,2,0,3,2,5}));

    }
}
