class TimeMap {

    Map<String,List<Map.Entry<Integer,String>>> map;
    public TimeMap() {
        map=new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        List<Map.Entry<Integer,String>> list= map.getOrDefault(key, new ArrayList<>());
        list.add(new AbstractMap.SimpleEntry<>(timestamp,value));
        //map.put(key,map.getOrDefault(key, new ArrayList<>()).add(new AbstractMap.SimpleEntry<>(timestamp,value)));
        map.put(key,list);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        List<Map.Entry<Integer,String>> list=map.get(key);
        if(list.size()==0)
            return "";
        return search(list, 0, list.size()-1, timestamp, "");
    }
    public String search(List<Map.Entry<Integer,String>> list,int low,int high,int target,String res){
        if(low>high)
            return res;
        int mid=low+(high-low)/2;
        if(list.get(mid).getKey()==target){
            return list.get(mid).getValue();
        }
        else if(list.get(mid).getKey()<target){
            res=list.get(mid).getValue();
            low=mid+1;
        }
        else{
            // res=list.get(mid).getValue();
            high=mid-1;
        }
        return search(list, low, high, target, res);
    }
}
