class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word.equals(abbr))
            return true;
        int i1=0,i2=0;
        for(int i=0;i<abbr.length();i++){
            if(abbr.charAt(i)=='0')
                return false;
            int asciiVal=(int)abbr.charAt(i);
            if(asciiVal>48 && asciiVal<=57){
                int num=asciiVal-48;
                i++;
                while(i<abbr.length()){
                    int temp= (int)abbr.charAt(i);
                    if(temp>=48 && temp<=57){
                        num=(num*10)+temp-48;
                        i++;
                    }
                    else{
                        break;
                    }
                }
                //skip i1
                i1=i1+num;
                i--;
            }
            else{
                if(i1>=word.length())
                    return false;
                if(word.charAt(i1)!=abbr.charAt(i))
                    return false;
                i1++;
            }
        }
        System.out.println("i1="+i1);
        return i1==word.length();
    }
   
}