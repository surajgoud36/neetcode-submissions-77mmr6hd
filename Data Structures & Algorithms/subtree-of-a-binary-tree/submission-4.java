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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      
        return check(root,subRoot);
    }

    public boolean check(TreeNode root,TreeNode subRoot){
        String res="";
        Deque<TreeNode> stack=new ArrayDeque<>();
        TreeNode curr=root;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                stack.push(curr);
                 if(curr.val==subRoot.val){
                    if(isSameTree(curr,subRoot))
                        return true;
                 }
                   
                curr=curr.left;
               
            }
            else{
                TreeNode temp=stack.pop();
                res+=temp.val;
                curr=temp.right;
            }
        }
        return false;
    }
     public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> st1=new ArrayDeque<>();
        Deque<TreeNode> st2=new ArrayDeque<>();
        while((p!=null && q!=null) || (!st1.isEmpty() && !st2.isEmpty())){
            if(p==null && q==null){
                TreeNode temp1=st1.pop();
                TreeNode temp2=st2.pop();
                if(temp1.val!=temp2.val)
                    return false;
                p=temp1.right;
                q=temp2.right;
                
            }
            else if(p!=null && q!=null){
                st1.push(p);
                st2.push(q);
                p=p.left;
                q=q.left;
            }
            else{
                return false;
            }
        }
        if(p!=null || q!=null)
            return false;
        if(!st1.isEmpty() || !st2.isEmpty())
            return false;
        return true;
    }
}
