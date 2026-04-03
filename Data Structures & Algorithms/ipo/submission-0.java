class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        Queue<Integer> minHeap=new PriorityQueue<>((a,b)->capital[a]-capital[b]);
        Queue<Integer> maxHeap=new PriorityQueue<>((a,b)->profits[b]-profits[a]);

        for(int i=0;i<profits.length;i++){
            minHeap.add(i);
        }

        for(int i=1;i<=k;i++){
            while(!minHeap.isEmpty()&&capital[minHeap.peek()]<=w){
                maxHeap.add(minHeap.poll());
            }

            if(!maxHeap.isEmpty())
                w+=profits[maxHeap.poll()];
        }

        return w;

    }
}