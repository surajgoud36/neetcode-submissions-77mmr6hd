class Solution {
    public String predictPartyVictory(String senate) {
        int banR=0,banD=0,countR=0,countD=0;
        StringBuilder sb=new StringBuilder(senate);
        do{
            countR=0;
            countD=0;
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)=='R'){
                    if(banR>0){
                        banR--;
                        sb.deleteCharAt(i);
                        i--;
                    }
                    else{
                        banD++;
                        countR++;
                    }
                }
                else{
                    if(banD>0){
                        banD--;
                        sb.deleteCharAt(i);
                        i--;
                    }
                    else{
                        banR++;
                        countD++;
                    }
                }
            }
        }while(countR>0 && countD>0);

        if(countR!=0)
            return "Radiant";
        return "Dire";
             
    }
}