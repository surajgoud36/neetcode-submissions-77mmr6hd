class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        maxHeap=new PriorityQueue<>(Comparator.reverseOrder());
        minHeap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.add(num);
        // compare the roots
         if(!minHeap.isEmpty() && maxHeap.peek()>minHeap.peek()){
            int temp=maxHeap.poll();
            maxHeap.add(minHeap.poll());
            minHeap.add(temp);
        }
        if(maxHeap.size()-minHeap.size()>1){
            minHeap.add(maxHeap.poll());
        }

       
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size())
            return (double)(minHeap.peek()+maxHeap.peek())/2.0;
        return (double)maxHeap.peek();
    }
}
