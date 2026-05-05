class Solution {
    public String convert(String s, int numRows) {
        int len=s.length();
        int base=numRows+numRows-2;
        int cols=((int)Math.ceil(len*2.0/(double)base));
        int otherCol=cols/2;
        cols=(cols-otherCol)+(otherCol*(numRows-2));
        System.out.println("cols: "+cols);
        Character[][] arr = new Character[numRows][cols];
        int index=0,col=0;
        while(index<s.length()){
            for(int i=0;(index<s.length() && i<numRows);i++){
                arr[i][col]=s.charAt(index++);
            }
            col++;
            for(int i=numRows-2;(index<s.length() && i>0);i--){
                arr[i][col++]=s.charAt(index++);
            }

        }
        StringBuilder res=new StringBuilder();
        for(int i=0;i<numRows;i++){
            for(int j=0;j<cols;j++){
                if(arr[i][j]!=null)
                    res.append(arr[i][j]);
            }
                
        }
        return res.toString();
    }
}