class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1)));
        numRows--;
        List<Integer> prev=list.get(0);
        while(numRows>0){
            List<Integer> curr= new ArrayList<>();
            curr.add(1);
            for(int i=0;i<prev.size()-1;i++){
                curr.add(prev.get(i)+prev.get(i+1));
            }
            curr.add(1);
            list.add(curr);
            prev=curr;
            numRows--;
        }
        return list;
    }
}