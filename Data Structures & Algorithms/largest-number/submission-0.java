class Solution {
    public String largestNumber(int[] nums) {
       //Arrays.sort(nums,(a,b)->Integer.toString(b).compareTo(Integer.toString(a)));
       String[] arr= Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
       Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
       String res= String.join("",arr);
       return res.charAt(0)=='0'? "0":res;
              
    }
}