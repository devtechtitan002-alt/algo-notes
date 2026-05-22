package Revision.PriorityQueue;

import java.util.PriorityQueue;

public class FindMedianfromDataStream {
    static class MedianFinder {

    // maintain two heaps one is min-heap and another is max-heap 
    // balanced insertion on both heaps and median depends heaps sizes
    PriorityQueue<Integer> min = null;
    PriorityQueue<Integer> max = null;

    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b)->(b-a));
    }
    
    public void addNum(int num) {

        if(!max.isEmpty() && num >= max.peek()){
            min.offer(num);
        }else{
            max.offer(num);
        }

        // when both sizes difference is > 1 we should rebalance
        // when both sizes difference is > 1 we should rebalance
        if((max.size() - min.size()) > 1){
            min.offer(max.poll());
        }else if((min.size()-max.size()) > 1){
            max.offer(min.poll());
        }

    }
    
    public double findMedian() {
        if(max.size() > min.size()) return max.peek();
        else if(min.size() > max.size()) return min.peek();
        else return ((double)min.peek()+max.peek())/2;
    }

    }

    public static void main(String[] args){

        MedianFinder medFind = new MedianFinder();

        
        medFind.addNum(1);
        System.out.println(medFind.findMedian());
        medFind.addNum(2);
        System.out.println(medFind.findMedian());
        medFind.addNum(3);
        System.out.println(medFind.findMedian());
        medFind.addNum(4);
        System.out.println(medFind.findMedian());
        medFind.addNum(5);
        System.out.println(medFind.findMedian());
        
        
        System.out.println("-------------");
        
        /*
        medFind.addNum(1);
        System.out.println(medFind.findMedian());
        medFind.addNum(2);
        System.out.println(medFind.findMedian());
        medFind.addNum(3);
        System.out.println(medFind.findMedian());
        */

        System.out.println("-------------");

        /* 
        medFind.addNum(2);
        System.out.println(medFind.findMedian());
        medFind.addNum(3);
        System.out.println(medFind.findMedian());
        */

    }
}
