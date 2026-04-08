class MovingAverage {
    int sum;
    int size;
    int currSize;
    Queue<Integer> window;
    public MovingAverage(int size) {
        sum=0;
        this.size=size;
        currSize=0;
        window=new ArrayDeque<>();
    }
    
    public double next(int val) {
        if(currSize==size){
            sum-=window.poll();
        }
        else
            currSize++;
            
            sum+=val;
            window.add(val);
            double avg=sum/(double)currSize;
            return avg;

    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
