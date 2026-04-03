class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,Double> weight=new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        int i=0;
        for(List<String> equation:equations){
            String num=equation.get(0);
            String den=equation.get(1);
            add(num,weight,parent);
            add(den,weight,parent);
            String rootX=find(num,weight,parent);
            String rootY=find(den,weight,parent);
            if(!rootX.equals(rootY)){
                parent.put(rootY,rootX);
                weight.put(rootY,(values[i]*weight.get(num))/weight.get(den));
            }

            i++;
        }
        double[] res=new double[queries.size()];
        i=0;
        for(List<String> query:queries){
            String num=query.get(0);
            String den=query.get(1);
            if(!parent.containsKey(num) || !parent.containsKey(den)){
                res[i++]=-1.0;
                continue;
            }
            String rootX=find(num,weight,parent);
            String rootY=find(den,weight,parent);
            if(!rootX.equals(rootY)){
                res[i++]=-1.0;
                continue;
            }
            res[i++]=weight.get(den)/weight.get(num);


        }
        return res;

    }
    public String find(String val,Map<String,Double> weight,Map<String, String> parent){
        if(val.equals(parent.get(val)))
            return val;
        String origParent=parent.get(val);
        parent.put(val,find(origParent,weight,parent));
        weight.put(val,weight.get(val)*weight.get(origParent));
        return parent.get(val);
        
    }
    public void add(String variable,Map<String,Double> weight,Map<String, String> parent){
        if(!parent.containsKey(variable)){
            parent.put(variable,variable);
            weight.put(variable,1.0);
        }
    }
}