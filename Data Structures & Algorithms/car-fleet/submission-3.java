record Pair(int position,double time){}
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // single array of time
        int len=position.length;
        List<Pair> list=new ArrayList<>();
        double[] time=new double[len];
        for(int i=0;i<len;i++){
            int distance=target-position[i];
            time[i]=(double)distance/speed[i];
            list.add(new Pair(position[i],time[i]));
        }
        Collections.sort(list,(a,b)-> Integer.compare(a.position(),b.position()));
        int res=1;
        double prev=list.get(len-1).time();
        for(int i=len-2;i>=0;i--){
            double currTime=list.get(i).time();
            if(currTime>prev){
               prev=currTime;
               res++;
               
            }
            
        }

        return res;
    }
}
