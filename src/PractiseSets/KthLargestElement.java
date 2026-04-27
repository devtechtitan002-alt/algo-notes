package PractiseSets;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import java.util.PriorityQueue;
public class KthLargestElement {
    static class Solution{
        /*
        public int kthLargest(int[] nums,int k){

            PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b); // by default also its been ascending order

            for(int num : nums){
                minHeap.add(num);
                if(minHeap.size() > k) minHeap.poll();
            }

            return minHeap.peek();
        }
        */

        public void  swap(int[] nums,int i,int j){
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
        }

        public int partitioning(int[] nums,int low,int high){
            int pivot = nums[high];
            int i = low-1;
            for(int j=low;j<high;j++){
                if(nums[j]<pivot){
                    i++;
                    swap(nums,i,j);
                }
            }
            swap(nums,i+1,high);
            return i+1;
        }

        public int quickSelect(int[] nums,int left,int right,int target){
            int p = partitioning(nums,left,right);
            if(p==target) return nums[p];
            else if(p < target) return quickSelect(nums,p+1,right,target);
            else return quickSelect(nums,left,p-1,target);
        }
        
        public int findKthLargest(int[] nums, int k){
            int n = nums.length;
            return quickSelect(nums,0,n-1,n-k);
        }

        /*
        import java.util.Random;

public class KthLargestElement {

    Random rand = new Random();

    public void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public int partitioning(int[] nums, int low, int high){
        // 🔥 pick random pivot and move it to end
        int pivotIndex = low + rand.nextInt(high - low + 1);
        swap(nums, pivotIndex, high);

        int pivot = nums[high];
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(nums[j] < pivot){
                i++;
                swap(nums, i, j);
            }
        }

        swap(nums, i + 1, high);
        return i + 1;
    }

    public int quickSelect(int[] nums, int left, int right, int target){
        // ✅ important base case
        if(left == right) return nums[left];

        int p = partitioning(nums, left, right);

        if(p == target) return nums[p];
        else if(p < target) return quickSelect(nums, p + 1, right, target);
        else return quickSelect(nums, left, p - 1, target);
    }

    public int findKthLargest(int[] nums, int k){
        int n = nums.length;
        return quickSelect(nums, 0, n - 1, n - k);
    }
}
     */
    } 
}
