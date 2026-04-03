class Solution {
    int candies;
    public int candy(int[] ratings) {
        candies=0;
        int[] candyArray=new int[ratings.length];
       getCandies(ratings,0,candyArray);


        return candies;
    }

    public void getCandies(int[] ratings,int index,int[] candyArray){
        
        for(int i=index;i<ratings.length;i++){
            int curr=0;
            //int nextIndex=i;
            if((i-1)>=index && ratings[i-1]<ratings[i])
                curr=candyArray[i-1]+1;
            if((i+1)<ratings.length && ratings[i+1]<ratings[i]){
               getCandies(ratings,i+1,candyArray);
               curr=Math.max(curr,candyArray[i+1]+1);
               if(curr==0)
                curr=1;
                candies+=curr;
                candyArray[i]=curr;
                return;
            }
            if(curr==0)
                curr=1;
            candies+=curr;
            candyArray[i]=curr;
           
        }



        for(int i=index;i<ratings.length;i++){
            int curr=0;
            if((i-1)>=index && ratings[i-1]<ratings[i])
                curr=candyArray[i-1]+1;
        }
        
    }
}