class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        List<Integer> res=new ArrayList<>();
        for(int x:nums1)
            s1.add(x);
        for(int x:nums2)
            s2.add(x);
        for(int x:s1){
            if(s2.contains(x))
                res.add(x);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}