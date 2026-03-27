import java.util.PriorityQueue;
public class FindMedianfromDataStream {
    static class MedianFinder {

    PriorityQueue<Integer> ascending;
    PriorityQueue<Integer> descending;

    public MedianFinder() {
        ascending = new PriorityQueue<>();
        descending = new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {

        if(!descending.isEmpty() && num < descending.peek()){
            if(!ascending.isEmpty() && num > ascending.peek()){
                descending.add(ascending.peek());
                ascending.add(num);
            }else{
                descending.add(num);
            }
        }else{
            ascending.add(num);
        }

        if( ascending.size() > descending.size() ) descending.add(ascending.poll());
        if( descending.size() > ascending.size() ) ascending.add(descending.poll());

        /*
        public void addNum(int num) {
    descending.add(num);  // always add to max heap first
    
    // if max of lower half > min of upper half → fix
    if(!ascending.isEmpty() && 
       descending.peek() > ascending.peek()){
        ascending.add(descending.poll());
    }
    
    // rebalance sizes — differ by at most 1
    if(descending.size() > ascending.size() + 1){
        ascending.add(descending.poll());
    }
    if(ascending.size() > descending.size()){
        descending.add(ascending.poll());
    }
}
    
public double findMedian() {
    if(descending.size() > ascending.size()) 
        return descending.peek();
    return (descending.peek() + ascending.peek()) / 2.0;
}
    */
        
    }
    
    public double findMedian() {
        int a = ascending.size();
        int d = descending.size();
        if(a==0) return descending.peek();
        if(d==0) return ascending.peek();
        if(a == d) return (double)(ascending.peek()+descending.peek())/2;
        return ascending.peek() > descending.peek() ? ascending.peek() : descending.peek();
    }
    }
    public static void main(String[] args){
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }
}
