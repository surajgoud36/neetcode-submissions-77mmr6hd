class UnionFind{
    Map<Integer,Integer> par;
    Map<Integer,Integer> rank;
    int count;
    public UnionFind(int n){
        par=new HashMap<>();
        rank=new HashMap<>();
        count=n;
        for(int i=0;i<n;i++){
            par.put(i,i);
            rank.put(i,1);
        }
    }
    public int find(int x){
        if(x==par.get(x))
            return x;
        par.put(x,find(par.get(x)));
        return par.get(x);
    }
    public boolean union(int x1,int x2){
        int p1=find(x1);
        int p2=find(x2);
        if(p1==p2)
            return false;
        if(rank.get(p1)==rank.get(p2)){
            par.put(p2,p1);
            rank.put(p1,rank.get(p1)+1);
        }
        else if(rank.get(p1)>rank.get(p2)){
            par.put(p2,p1);
        }
        else{
            par.put(p1,p2);
        }
        count--;
        return true;
    }
}
class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        int n=nums.length;
        UnionFind uf=new UnionFind(n);
        Map<Integer,Integer> map = new HashMap<>();
       
        for(int i=0;i<n;i++){
            int f=2;
            int num=nums[i];
            while(f*f<=num){
                if(num%f==0){
                    if(map.containsKey(f))
                        uf.union(map.get(f),i);
                    else
                        map.put(f,i);
                }
                while(num%f==0)
                    num/=f;
                f++;
            }
            if(num>1){
                 if(map.containsKey(num))
                        uf.union(map.get(num),i);
                    else
                        map.put(num,i);
            }
        }
        return uf.count == 1;
    }
}