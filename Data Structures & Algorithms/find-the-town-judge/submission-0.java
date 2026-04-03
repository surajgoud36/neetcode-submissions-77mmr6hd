class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer,Set<Integer>> outgoing=new HashMap<>();
        Map<Integer,Set<Integer>> incoming=new HashMap<>();

        for(int[] t:trust){
            outgoing.computeIfAbsent(t[0],k->new HashSet<>()).add(t[1]);
            incoming.computeIfAbsent(t[1],k-> new HashSet<>()).add(t[0]);
           // System.out.println("size = "+incoming.get(t[1]).size());
            // if(incoming.get(t[1]).size() == n-1 && !outgoing.containsKey(t[1]))
            //     return t[1];
        }
        for(int i=1;i<=n;i++){
            if(incoming.containsKey(i) && incoming.get(i).size()==n-1 && !outgoing.containsKey(i))
                return i;
        }
        return -1;
    }
}