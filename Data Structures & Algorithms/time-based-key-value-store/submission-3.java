record Pair(String value,int timeStamp){}
class TimeMap {
    Map<String,List<Pair>> map = new HashMap<>();
    public TimeMap() {
        map=new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,k->new ArrayList<>()).add(new Pair(value,timestamp));
    }
    
    public String get(String key, int timestamp) {
        String res="";
        if(!map.containsKey(key))
            return res;
        List<Pair> searchSpace=map.get(key);
        int low=0,high=searchSpace.size()-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            Pair curr=searchSpace.get(mid);
            if(curr.timeStamp()==timestamp)
                return curr.value();
            else if(timestamp<curr.timeStamp())
                high=mid-1;
            else{
                low=mid+1;
                res=curr.value();
            }
        }
        return res;
    }
}
