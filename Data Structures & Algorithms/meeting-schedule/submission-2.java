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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size()==0)
            return true;
        intervals.sort(Comparator.comparingInt((Interval k)->k.start).thenComparingInt(k->k.end));
        int currStart=intervals.get(0).start;
        int currEnd=intervals.get(0).end;
        for(int i=1;i<intervals.size();i++){
            if(intervals.get(i).start<currEnd)
                return false;
            currStart=intervals.get(i).start;
            currEnd=intervals.get(i).end;
        }
        return true;
    }
}
