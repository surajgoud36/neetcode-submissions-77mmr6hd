class Solution {
    public String predictPartyVictory(String senate) {
        int[] c = new int[2];
        StringBuilder psb=new StringBuilder(senate);
        do{
            StringBuilder sb = new StringBuilder();
            for(char ch: psb.toString().toCharArray()){
            if(ch == 'R'){
                if(c[0]>0){
                    c[0]--;
                }else{
                    sb.append('R');
                    c[1]++;
                }
            }else{
                 if(c[1]>0)
                    c[1]--;
                else{
                    sb.append('D');
                    c[0]++;
                }
            }
            }
            psb=sb;
            //System.out.println(psb.toString());
        }while( !(psb.indexOf("R")==-1 || psb.indexOf("D")==-1));
        //System.out.println(Arrays.toString(c));
        //return "Radiant";
        if(psb.indexOf("R")==-1)
            return "Dire";
        return "Radiant";
        //return psb.toString().equals("R")?"Radiant":"Dire";
    }
}

