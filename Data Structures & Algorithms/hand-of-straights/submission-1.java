class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int len=hand.length;
        if(len%groupSize!=0)
            return false;
        int numGroups=len/groupSize;
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int x:hand){
            map.put(x,map.getOrDefault(x,0)+1);
        }
        //List<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
        //list.sort(Comparator.comparingInt(Map.Entry::getKey));
        for(int i=0;i<numGroups;i++){
            //System.out.println("map = "+map);
            Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();
            int size=0,prev=-1;
            while(it.hasNext() && size<groupSize){
                Map.Entry<Integer,Integer> entry = it.next();
                if(prev==-1){
                    prev=entry.getKey();
                    if(entry.getValue()==1)
                        it.remove();
                    else
                        entry.setValue(entry.getValue()-1);
                    size++;
                    continue;
                }

                int curr=entry.getKey();
                if(prev+1!=curr){
                    //System.out.println("prev = "+prev+"curr = "+curr);
                    //System.out.println("here");
                     break;
                }
                   
                prev=curr;
                 if(entry.getValue()==1)
                        it.remove();
                    else
                        entry.setValue(entry.getValue()-1);
                 size++;
            }
            //System.out.println("size = "+size);
            if(size!=groupSize)
                return false;
        }
        return true;
    }
}
