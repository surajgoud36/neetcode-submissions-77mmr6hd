class Solution {
    public int romanToInt(String s) {
        Map<Character,List<Character>> map = new HashMap<>();
        Map<Character,Integer> getMap=new HashMap<>();
        getMap.put('I',1);
        getMap.put('V',5);
        getMap.put('X',10);
        getMap.put('L',50);
        getMap.put('C',100);
        getMap.put('D',500);
        getMap.put('M',1000);
        List<Character> list = new ArrayList<>();
        list.add('V');
        list.add('X');
        map.put('I',list);
        list=new ArrayList<>();
        list.add('L');
        list.add('C');
        map.put('X',list);
        list=new ArrayList<>();
        list.add('D');
        list.add('M');
        map.put('C',list);

        return process(s,map,0,getMap);
    }
    public int process(String s, Map<Character,List<Character>> map,int i, Map<Character,Integer> getMap){
        if(i>=s.length())
            return 0;
        if(i==s.length()-1){
            return getMap.get(s.charAt(i));
        }
        char curr=s.charAt(i);
        char next=s.charAt(i+1);
        if(map.containsKey(curr) && map.get(curr).contains(next)){
            int c=getMap.get(curr);
            int n=getMap.get(next);
            return (n-c)+process(s,map,i+2,getMap);
        }
        return getMap.get(curr)+process(s,map,i+1,getMap);
    }
}