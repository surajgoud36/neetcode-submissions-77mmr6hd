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
    // same traversal for both trees and if they differ at any step just return false
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null)
            return true;
        if(p==null && q!=null)
            return false;
         if(p!=null && q==null)
            return false;

        Deque<TreeNode> stack1=new ArrayDeque<>();
        Deque<TreeNode> stack2=new ArrayDeque<>();
        while(p!=null || stack1.size()!=0 && q!=null || stack2.size()!=0 ){
            if(p!=null && q!=null){
                stack1.push(p);
                stack2.push(q);
                p=p.left;
                q=q.left;
            }
            else if(p==null && q==null){
                TreeNode node1=stack1.pop();
                TreeNode node2= stack2.pop();
                if(node1.val!=node2.val)
                    return false;
                if(node1.right!=null)
                    p=node1.right;
                q=node2.right;
                
            }
            else{
                System.out.println("here elese");
                return false;
            }
        }
         System.out.println("after elese");
        if(p!=null || stack1.size()!=0)
            return false;
        if(q!=null || stack2.size()!=0)
            return false;

        return true;
    }
}
