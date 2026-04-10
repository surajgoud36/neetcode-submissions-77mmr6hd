class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] transformed = new int[edges.length][4];
        for(int i=0;i<edges.length;i++){
            transformed[i]=Arrays.copyOf(edges[i],4);
            transformed[i][3]=i;
        }
        Arrays.sort(transformed,Comparator.comparingInt((int[] k)->k[2]));
        edges=transformed;
        int mstScore=0;
        UnionFind uf=new UnionFind(n);
        int edgeCount=0;
        for(int[] edge: edges){
            if(edgeCount>=n-1)
                break;
            if(uf.union(edge[0],edge[1])){
                mstScore+=edge[2];
                edgeCount++;
            }
        }
        List<Integer> critical = new ArrayList<>();
        List<Integer> pcritical=new ArrayList<>();
        // to determine critical edge we need to definitely not inlcude it in mst build up\
        // to determine pcritical edge we definitely have to include it in the res
        for(int[] edge:edges){
            int[] exclusionScore=findMstScore(edges,edge,n,true);
            int[] inclusionScore=findMstScore(edges,edge,n,false);
            if(exclusionScore[1]<n-1 || exclusionScore[0]>mstScore){
                critical.add(edge[3]);
                continue;
            }
            System.out.println("MST Score = "+mstScore);
            System.out.println("Inclusion Score= "+inclusionScore[0]+" exclusion score = "+exclusionScore[0]);
            if(inclusionScore[0]==mstScore)
                pcritical.add(edge[3]);
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(critical);
        res.add(pcritical);
        return res;
    }
    public int[] findMstScore(int[][] edges,int[] exempted,int n,boolean excluded){
        UnionFind uf=new UnionFind(n);
        int mstScore=0;
        int edgeCount=0;
        if(!excluded){
            uf.union(exempted[0],exempted[1]);
            mstScore+=exempted[2];
            edgeCount++;
        }
         for(int[] edge: edges){
            if(excluded && edge[0]==exempted[0] && edge[1]==exempted[1])
                continue;
            if(edgeCount>=n-1)
                break;
            if(uf.union(edge[0],edge[1])){
                mstScore+=edge[2];
                edgeCount++;
            }
        }
        return new int[]{mstScore,edgeCount};
    }
    
}

public class UnionFind{
    Map<Integer,Integer> parent;
    Map<Integer,Integer> rank;
    public UnionFind(int n){
        parent=new HashMap<>();
        rank=new HashMap<>();
        for(int i=0;i<n;i++){
            parent.put(i,i);
            rank.put(i,1);
        }
    }
    public int find(int curr){
        if(curr!=parent.get(curr)){
            parent.put(curr,find(parent.get(curr)));
        }
        return parent.get(curr);
    }
    public boolean union(int p1,int p2){
        p1=find(p1);
        p2=find(p2);
        if(p1==p2)
            return false;
        if(rank.get(p1)==rank.get(p2)){
            parent.put(p2,p1);
            rank.put(p1,rank.get(p1)+1);
        }
        else if(rank.get(p1)>rank.get(p2))
            parent.put(p2,p1);
        else
            parent.put(p1,p2);
        return true;
    }
}

