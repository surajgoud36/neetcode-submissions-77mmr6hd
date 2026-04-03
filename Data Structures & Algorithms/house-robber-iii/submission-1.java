/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<TreeNode,Integer[]> dp;
    public int rob(TreeNode root) {
        dp=new HashMap<>();
        return robbed(root,false);
    }
    public int robbed(TreeNode root,boolean prev){
        if(root==null)
            return 0;
        if(dp.containsKey(root)){
            Integer[] arr=dp.get(root);
            if(prev && arr[1]!=null)
                return arr[1];
            if(!prev && arr[0]!=null)
                return arr[0];
        }
        if(!dp.containsKey(root))
            dp.put(root,new Integer[2]);
        
        Integer[] arr=dp.get(root);
        if(prev){
            int temp= robbed(root.left,false)+robbed(root.right,false);
           
            arr[1]=temp;
            return temp;
        }
        int out1=robbed(root.left,false)+robbed(root.right,false);
        int out2=root.val+robbed(root.left,true)+robbed(root.right,true);
        int temp=Math.max(out1,out2);
        arr[0]=temp;
        return temp;
    }
}