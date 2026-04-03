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
    int x=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TreeNode root=null;
        // for(int i=0;i<preorder.length;i++){
        //     TreeNode croot=makeRoot(preorder[i],)
        // }
        x=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
         System.out.println("he;;p");
        return makeRoot(inorder,0,inorder.length-1,preorder,map);
    }

    public TreeNode makeRoot(int[] inorder,int low,int high,int[] preorder,Map<Integer,Integer> map){
         TreeNode croot=null;
        // for(int i=low;i<=high;i++){
            int i=map.get(preorder[x]);
            if(inorder[i]==preorder[x]){
                System.out.println("root found= "+preorder[x]);
                 croot=new TreeNode(preorder[x]);
                if(i-low>0){
                    x=x+1;
                    croot.left=makeRoot(inorder,low,i-1,preorder,map);
                    if(inorder[i]==3){
                        System.out.println(" x val = "+x+" its val = "+preorder[x]);
                    }
                }
                   
                if(high-i>0){
                    x=x+1;
                    croot.right=makeRoot(inorder,i+1,high,preorder,map);
                     
                }
                    
                return croot;
            }
            
       // }
        System.out.println("root found null = "+preorder[x]);
        return croot;
    }
}
