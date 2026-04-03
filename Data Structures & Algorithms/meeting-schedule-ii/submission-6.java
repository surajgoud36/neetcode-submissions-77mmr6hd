/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
         if(intervals.size()==0)
                return 0;
        intervals.sort(Comparator.comparingInt((Interval k)->k.start).thenComparingInt(k->k.end));
        PriorityQueue<Interval> pq=new PriorityQueue<>(Comparator.comparingInt((Interval k)->k.end));
        int count=1;
        pq.add(intervals.get(0));
        for(int i=1;i<intervals.size();i++){
            Interval temp=intervals.get(i);
            while(!pq.isEmpty() && pq.peek().end<=temp.start){
                pq.poll();
            }
            pq.add(temp);
            count=Math.max(count,pq.size());
        }
        return count;
    }
}
