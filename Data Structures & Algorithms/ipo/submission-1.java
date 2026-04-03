class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>(Comparator.comparingInt((Integer p)->capital[p]));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt((Integer p)->profits[p]).reversed());
        int tot=w;
        for(int i=0;i<profits.length;i++){
            minHeap.add(i);
        }
        for(int i=1;i<=k;i++){
            while(!minHeap.isEmpty() && capital[minHeap.peek()]<=tot)
                maxHeap.add(minHeap.poll());
            if(maxHeap.isEmpty())
                break;
            tot+=profits[maxHeap.poll()];
        }
        return tot;

    }


}