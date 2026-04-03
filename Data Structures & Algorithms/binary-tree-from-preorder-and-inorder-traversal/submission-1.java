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
         System.out.println("he;;p");
        return makeRoot(inorder,0,inorder.length-1,preorder);
    }

    public TreeNode makeRoot(int[] inorder,int low,int high,int[] preorder){
         TreeNode croot=null;
        for(int i=low;i<=high;i++){
            if(inorder[i]==preorder[x]){
                System.out.println("root found= "+preorder[x]);
                 croot=new TreeNode(preorder[x]);
                if(i-low>0){
                    x=x+1;
                    croot.left=makeRoot(inorder,low,i-1,preorder);
                    if(inorder[i]==3){
                        System.out.println(" x val = "+x+" its val = "+preorder[x]);
                    }
                }
                   
                if(high-i>0){
                    x=x+1;
                    croot.right=makeRoot(inorder,i+1,high,preorder);
                     
                }
                    
                return croot;
            }
            
        }
        System.out.println("root found null = "+preorder[x]);
        return croot;
    }
}
