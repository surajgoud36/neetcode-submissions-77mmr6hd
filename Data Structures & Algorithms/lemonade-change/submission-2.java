class Solution {
    public boolean lemonadeChange(int[] bills) {
        // always try to give off the bigger notes

        Map<Integer,Integer> change = new HashMap<>();
        for(int bill:bills){
            if(bill==5)
                change.put(5,change.getOrDefault(5,0)+1);
            else if(bill==10){
                if(!change.containsKey(5))
                    return false;
                change.put(10,change.getOrDefault(10,0)+1);
                if(change.get(5)==1)
                    change.remove(5);
                else
                    change.put(5,change.get(5)-1);
                

            }
            else{
                if(!check20(change))
                    return false;
            }
        }
        return true;
    }

    public boolean check20(Map<Integer,Integer> map){
        if(!map.containsKey(5))
            return false;
        if(map.containsKey(10)){
            map.put(20,map.getOrDefault(20,0)+1);
            map.put(5,map.get(5)-1);
            map.put(10,map.get(10)-1);
        }
        else{
            if(map.get(5)<3)
                return false;
            map.put(20,map.getOrDefault(20,0)+1);
            map.put(5,map.get(5)-3);
        }
        if(map.get(5)==0)
            map.remove(5);
        if(map.containsKey(10) && map.get(10)==0)
            map.remove(10);
        return true;
    }
}