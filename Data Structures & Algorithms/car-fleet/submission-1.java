class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer,Double> map=new HashMap<>();
        for(int i=0;i<position.length;i++){
            double time=(target-position[i])/(double)speed[i];
            time=Math.round(time*10.0)/10.0;
            map.put(target-position[i],time);
        }

        List<Map.Entry<Integer,Double>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByKey());
        int count=1;
        System.out.println(list);
        for(int i=1;i<list.size();i++){
            double prevTime=list.get(i-1).getValue();
            double currentTime=list.get(i).getValue();
            if(prevTime<currentTime){
                count++;
            }
            else{
                // greater than or equal same boat 
                list.get(i).setValue(prevTime);
            }
        }
        return count;
    }
}
