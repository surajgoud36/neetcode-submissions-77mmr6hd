class Solution {
    boolean[] visited;
    Integer[] next;
    Map<Integer,Set<Integer>> adj;
    String res;
    Set<Integer> path;
    Set<Integer> visit;
    public String foreignDictionary(String[] words) {
       adj=new HashMap<>();
       path=new HashSet<>();
       visit=new HashSet<>();
       res="";
      if(words.length==1)
        return words[0];
      visited=new boolean[26];
      next=new Integer[26];
    //   for(int i=0;i<26;i++)
    //     next[i]=-1;
    for(int i=0;i<words.length-1;i++){
        String s1=words[i];
        String s2=words[i+1];
        int i1=0,i2=0;
        int flag=0;
        while(i1<s1.length() && i2<s2.length()){
            int ind1=s1.charAt(i1)-'a';
            int ind2=s2.charAt(i2)-'a';
            if(ind1==ind2){
                adj.computeIfAbsent(ind1,k->new HashSet<>());
                adj.computeIfAbsent(ind2,k->new HashSet<>());
                // if(next[ind1]==null)
                //     next[ind1]=-1;
                // if(next[ind2]==null)
                //     next[ind2]=-1;
                i1++;
                i2++;
                continue;
            }
            else{
                 next[ind1]=ind2;
                adj.computeIfAbsent(ind1,k->new HashSet<>()).add(ind2);
                adj.computeIfAbsent(ind2,k->new HashSet<>());
                i1++;
                i2++;
                flag=1;
                break;
            }
        }
        if(flag==0 && i1<s1.length() && i2==s2.length())
            return "";
        while(i1<s1.length()){
            int ind1=s1.charAt(i1)-'a';
            adj.computeIfAbsent(ind1,k->new HashSet<>());
            i1++;
        }
        while(i2<s2.length()){
            int ind2=s2.charAt(i2)-'a';
            adj.computeIfAbsent(ind2,k->new HashSet<>());
            i2++;
        }

    }
    // for(int i:adj.keySet()){
    //     System.out.print((char)(i+'a')+"-> ");
    //     for(int j:adj.get(i))
    //         System.out.print((char)(j+'a')+", ");
    // }
    // System.out.println(adj);
    for(int i:adj.keySet()){
        if(!dfs(i))
            return "";
    }
      return new StringBuilder(res).reverse().toString();
    }
    public boolean dfs(int src){
        if(path.contains(src))
            return false;
        if(visit.contains(src))
            return true;
        visit.add(src);
        path.add(src);
        for(int x:adj.get(src)){
            if(!dfs(x))
                return false;
        }
        res+=(char)(src+'a');
        path.remove(src);
        return true;
    }
}
