class MedianFinder {
    PriorityQueue<Integer> rightHeap;
    PriorityQueue<Integer> leftHeap;
    public MedianFinder() {
        rightHeap = new PriorityQueue<>();
        leftHeap = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if(leftHeap.isEmpty() || num<=leftHeap.peek()){
            leftHeap.add(num);
            
        }else{
            rightHeap.add(num);
        }
        
       
        if(leftHeap.size()>rightHeap.size()+1)
            rightHeap.add(leftHeap.poll());
        else if(rightHeap.size()> leftHeap.size())
            leftHeap.add(rightHeap.poll());
    }
    
    public double findMedian() {
        if(leftHeap.size() == rightHeap.size())
            return (leftHeap.peek() +(double)rightHeap.peek()) / 2.0;
        return leftHeap.peek();
    }
}
