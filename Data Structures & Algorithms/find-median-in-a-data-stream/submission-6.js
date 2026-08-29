class MedianFinder {
    constructor() {
        this.minHeap = new PriorityQueue((p,q)=> p-q);
        this.maxHeap = new PriorityQueue((p,q)=> q-p);
    }

    /**
     *
     * @param {number} num
     * @return {void}
     */
    addNum(num) {
       if (this.maxHeap.isEmpty() || num <= this.maxHeap.front()) {
        this.maxHeap.enqueue(num);
    } else {
        this.minHeap.enqueue(num);
    }

    // Balance
    if (this.maxHeap.size() > this.minHeap.size() + 1) {
        this.minHeap.enqueue(this.maxHeap.dequeue());
    } 
    else if (this.minHeap.size() > this.maxHeap.size()) {
        this.maxHeap.enqueue(this.minHeap.dequeue());
    }
    }

    /**
     * @return {number}
     */
    findMedian() {
        if(this.minHeap.size() === this.maxHeap.size()){
            return (this.minHeap.front() + this.maxHeap.front()) / 2;
        }
        return this.maxHeap.front();
    }
}
