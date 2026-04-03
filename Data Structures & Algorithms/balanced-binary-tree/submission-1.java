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

    public boolean isBalanced(TreeNode root) {
        Deque<TreeNode> stack=new ArrayDeque<>();
        Deque<Boolean> visited=new ArrayDeque<>();

        if(root==null)
            return true;

        stack.push(root);
        visited.push(false);
        
        while(stack.size()!=0){
            TreeNode node=stack.pop();
            boolean state=visited.pop();
            System.out.println("Node.val= "+node.val);
            if(node!=null){
                 if(state==true){
                int left=0,right=0;
                if(node.right!=null)
                    right=node.right.val;
                if(node.left!=null)
                    left=node.left.val;
                if(Math.abs(left-right)>1)
                    return false;
                node.val=(Math.max(left,right)+1);
            }
            else{
                System.out.println("Node.val= (2) "+node.val);
                stack.push(node);
                visited.push(true);
                System.out.println("nide= "+(node.right==null));
                if(node.right!=null){
                    
                    stack.push(node.right);
                    visited.push(false);
                }
                if(node.left!=null){
                    stack.push(node.left);
                    visited.push(false);
                }
                
                
            }
            }
           
           
        }
        return true;
        
    }
    // public int diff(TreeNode root){
    //     if(root==null)
    //         return 0;
        
    // }
}
