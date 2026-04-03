class MedianFinder {
    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;
    public MedianFinder() {
        small=new PriorityQueue<>(Comparator.reverseOrder());
        large=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        small.add(num);
        // check if small<= large is intact
        if(large.size()!=0 && small.peek()>large.peek()){
            // send it to other side 
            large.add(small.poll());
        }

        // check sizes
        if(small.size()>large.size()+1){
            large.add(small.poll());
        }

        if(large.size()>small.size()+1){
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        if(large.size()>small.size())
            return large.peek();
        if(small.size()>large.size())
            return small.peek();
        System.out.println("small= "+small.peek()+" large= "+large.peek());
        return (small.peek()+large.peek())/2.0;
    }
}
