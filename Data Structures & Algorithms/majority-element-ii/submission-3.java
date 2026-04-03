record Pair(boolean status,int candidate){}
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res=new ArrayList<>();
        int count=0;
        int can=0;
        Pair p=getCandidate(nums,false,0);
        if(p.status()){
            res.add(p.candidate());
            p=getCandidate(nums,true,p.candidate());
        }
        if(p.status()){
            res.add(p.candidate());
        }
        return res;
    }
    public Pair getCandidate(int[] nums,boolean skip,int toSkip){
        int count=0;
        int can=0;
        int can2=0;
        for(int i=0;i<nums.length;i++){
            if(skip && nums[i]==toSkip)
                continue;
            if(count==0){
                can=nums[i];
                count=1;
            }
            else if(nums[i]==can)
                count++;
            else
                count--;
        }
        // check freq
        
            for(int i=nums.length-1;i>=0;i--){
            if(skip && nums[i]==toSkip)
                continue;
            if(count==0){
                can2=nums[i];
                count=1;
            }
            else if(nums[i]==can2)
                count++;
            else
                count--;
        }
        
        
        //can=can2;
        int freq1=0;
        for(int x:nums){
            if(can==x)
                freq1++;
        }
         int freq2=0;
        for(int x:nums){
            if(can2==x)
                freq2++;
        }
        int target=(int)Math.floor(nums.length/3.0)+1;
        //System.out.println("freq= "+freq+" candidate="+can+" target = "+target);
        if(freq1>=target)
            return new Pair(true,can);
        if(freq2>=target)
            return new Pair(true,can2);
        return new Pair(false,0);
    }
}