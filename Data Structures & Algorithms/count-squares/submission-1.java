record Pair(int x,int y){}
class CountSquares {
    Map<Pair,Integer> map;
    public CountSquares() {
        map=new HashMap<>();
    }
    
    public void add(int[] point) {
        Pair p=new Pair(point[0],point[1]);
        map.put(p,map.getOrDefault(p,0)+1);
    }
    
    public int count(int[] point) {
        int qx=point[0],qy=point[1];
        int count=0;
        System.out.println(map);
        for(Pair p:map.keySet()){
            if(p.equals(new Pair(qx,qy)))
                continue;
            int x=p.x();
            int y=p.y();
            int pcount=0;
            // check if they form a diagonal with qx,qy
            if(Math.abs(x-qx)==Math.abs(y-qy)){
                Pair p1=new Pair(x,qy);
                Pair p2=new Pair(qx,y);
                if(map.containsKey(p1) && map.containsKey(p2)){
                    pcount+=map.get(p)*map.get(p1)*map.get(p2)*map.getOrDefault(new Pair(qx,qy),1);
                }
            }
           // System.out.println("qx,qy: "+qx+","+qy+" pcoint: "+pcount);
            count+=pcount;
        }
        return count;
    }
}
