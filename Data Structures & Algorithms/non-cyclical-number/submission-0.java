class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set=new HashSet<>();
        while(true){
            if(n==1)
                return true;
            int num=0;
            while(n>0){
                num+=(n%10)*(n%10);
                n/=10;
            }
            if(set.contains(num))
                return false;
            set.add(num);
            n=num;
        }
    }
}