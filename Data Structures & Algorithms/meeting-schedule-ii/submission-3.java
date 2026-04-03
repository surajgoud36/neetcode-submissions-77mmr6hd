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
         Collections.sort(intervals,(a,b)->Integer.compare(a.start,b.start));
         List<Interval> rem=new ArrayList<>();
        
        if(intervals.size()<=1)
            return intervals.size();
        Interval prev=intervals.get(0);
        int count=1;
        ArrayDeque<Interval> dq=new ArrayDeque<>();
        for(int i=1;i<intervals.size();i++){
            int start=intervals.get(i).start;
            int end=intervals.get(i).end;
            if(start<prev.end){
                // there is a conflict
                // if(prev.end>end){
                //     //rem.add(prev);
                //     add(dq,prev);
                //     prev=intervals.get(i);
                // }
                // else{
                //     // dont do anything
                //    // rem.add(intervals.get(i));
                //     add(dq,intervals.get(i));
                // }
                rem.add(intervals.get(i));

            }
            else{
                prev=intervals.get(i);
            }
             
        }

        while(!rem.isEmpty()){
            //Collections.sort(rem,(a,b)->Integer.compare(a.start,b.start));
            count++;
            List<Interval> trem=new ArrayList<>();
            prev=rem.get(0);
            for(int i=1;i<rem.size();i++){
            int start=rem.get(i).start;
            int end=rem.get(i).end;
            if(start<prev.end){
                // there is a conflict
                // if(prev.end>end){
                //     trem.add(prev);
                //     prev=intervals.get(i);
                // }
                // else{
                //     // dont do anything
                //     trem.add(rem.get(i));
                // }
                trem.add(rem.get(i));

            }
            else{
                prev=rem.get(i);
            }
             
            }
            rem=trem;
        }//end while
        // System.out.println(dq);
        // dq.forEach(x->System.out.println(x.start+" "+x.end));
        // return 1+dq.size();
        return count;
        
    }
    public void add(ArrayDeque<Interval> dq,Interval x){
        if(dq.isEmpty()){
            dq.add(x);
            return;
        }
        else{
            for(Interval i:dq){
                if(x.start>=i.end){
                    dq.remove(i);
                    dq.add(x);
                    return;
                }
            }
            dq.add(x);
        }
    }
}
