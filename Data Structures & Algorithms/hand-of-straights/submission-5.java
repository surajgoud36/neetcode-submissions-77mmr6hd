class Solution {
     int count;
    public boolean isNStraightHand(int[] hand, int groupSize) {
        count=hand.length;
        if(count%groupSize != 0)
            return false;
        int[] ca = new int[1001];
        for(int x: hand){
            ca[x]++;
        }
        while(count>0){
            for(int i=0;i<1001;i++){
                if(ca[i]>0){
                    if(!update(i,ca,groupSize))
                        return false;
                    i=-1;
                }
                    //return false;
               
            }
        }
        return count == 0;
    }

    public boolean update(int start,int[] ca,int size){
        for(int i=start;i<start+size;i++){
            if(ca[i]<=0)
                return false;
            ca[i]--;
            count--;

        }
        return true;
    }
}
