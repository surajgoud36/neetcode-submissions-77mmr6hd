class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,String> parent = new HashMap<>();
        Map<String,Double> weight = new HashMap<>();
        int i=0;
        for(List<String> eq:equations){
            String num=eq.get(0);
            String den=eq.get(1);
            add(num,parent,weight);
            add(den,parent,weight);
            String rootN=find(num,parent,weight);
            String rootD=find(den,parent,weight);
            // perform the union operation
            if(!rootN.equals(rootD)){
                parent.put(rootD,rootN);
                weight.put(rootD,(values[i]*weight.get(num))/weight.get(den));
            }
            i++;
        }
        double[] res=new double[queries.size()];
        i=0;
        for(List<String> q:queries){
            String a=q.get(0);
            String b=q.get(1);
            if(!parent.containsKey(a) || !parent.containsKey(b) || !find(a,parent,weight).equals(find(b,parent,weight)))
                {
                    res[i++]=-1.0;
                    continue;
                }
            res[i++]= weight.get(b)/weight.get(a);
        }
        return res;
    }

    public void add(String curr, Map<String,String> parent, Map<String,Double> weight){
        if(parent.containsKey(curr))
            return;
        parent.put(curr,curr);
        weight.put(curr,1.0);
    }
    public String find(String curr,Map<String,String> parent, Map<String,Double> weight){
        if(curr.equals(parent.get(curr)))
            return curr;
        String getParent=find(parent.get(curr),parent,weight);
        String origParent= parent.get(curr);
        weight.put(curr,weight.get(curr)*weight.get(origParent));
        parent.put(curr,getParent);
        return getParent;
    }
    
}