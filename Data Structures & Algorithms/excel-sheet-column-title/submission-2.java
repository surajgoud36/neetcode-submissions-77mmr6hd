class Solution {
    public String convertToTitle(int columnNumber) {
        Map<Integer,Character> map = new HashMap<>();
        for(int i=0;i<26;i++){
            map.put(i,(char)(65+i));
        }
        System.out.println(map);
        StringBuilder sb = new StringBuilder();
        while(columnNumber>25){
            int digit = ((columnNumber-1)%26);
           
            sb.append(map.get(digit));
            columnNumber=(columnNumber-1)/(26);
        }
        if(columnNumber-1>=0)
            sb.append(map.get(columnNumber-1));
        return sb.reverse().toString();
    }
}