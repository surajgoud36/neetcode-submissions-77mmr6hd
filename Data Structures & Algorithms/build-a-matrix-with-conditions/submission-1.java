record Couple(int ele,int count){}
record Pair(boolean status,List<Couple> list){}
record Stat(boolean status,int count){}
class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        Pair p1=getTopoOrder(rowConditions,k);
      //  System.out.println("I am here2");
        if(!p1.status())
            return new int[0][0];
        Pair p2 = getTopoOrder(colConditions,k);
       // System.out.println("I am here 1");
        if(!p2.status())
            return new int[0][0];
       // System.out.println("I am here");
        List<Couple> topList = p1.list();
        List<Couple> leftList = p2.list();
        Map<Integer,Integer> leftMapper=new HashMap<>();
        for(Couple c:leftList){
            leftMapper.put(c.ele(),c.count());
        }
        int[][] res=new int[k][k];
        int completed=0;
        int rowIndex=0;
        System.out.println(leftMapper);
        for(Couple guy:topList){
            int curr=guy.ele();
            res[rowIndex++][leftMapper.get(curr)-1]=curr;
        }
        return res;

    }

    Pair getTopoOrder(int[][] edges,int k){
        Map<Integer,Integer> visit=new HashMap<>();
        Set<Integer> path = new HashSet<>();
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int[] edge: edges){
            int src=edge[1];
            int dst=edge[0];
            map.computeIfAbsent(src,z-> new ArrayList<>());
            List<Integer> temp = map.get(src);
            if(!temp.contains(dst))
                temp.add(dst);
        }
        List<Couple> list = new ArrayList<>();
        Stat check;
        for(int i=1;i<=k;i++){
            check=dfs(visit,path,list,map,i);
            if(!check.status()){
                return new Pair(false,list);
            }

        }
        return new Pair(true,list);
    }
    public Stat dfs(Map<Integer,Integer> visit,Set<Integer> path,List<Couple> list, Map<Integer,List<Integer>> map, int ele){
        if(path.contains(ele))
            return new Stat(false,0);
        if(visit.containsKey(ele))
            return new Stat(true,visit.get(ele));
        //visit.add(ele);
        path.add(ele);
        int count=0;
        if(map.containsKey(ele)){
            for(int child:map.get(ele)){
                Stat next=dfs(visit,path,list,map,child);
                if(!next.status()){
                    return new Stat(false,count);
                }
                count+=next.count();   
            }
        }
        count++;
        path.remove(Integer.valueOf(ele));
        visit.put(ele,count);
        list.add(new Couple(ele,count));
        return new Stat(true,count);
    }
}