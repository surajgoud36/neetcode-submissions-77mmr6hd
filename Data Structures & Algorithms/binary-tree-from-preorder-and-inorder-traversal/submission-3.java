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
    Deque<Integer> stack;
    TreeNode root;
    int pre,in;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        stack = new ArrayDeque<>();
        root=null;
        pre=0;in=0;
        return build(preorder,inorder);
    }
    public TreeNode build(int[] preorder,int[] inorder){
        if(pre==preorder.length || in==inorder.length)
            return null;
        if(!stack.isEmpty() && stack.peek()==inorder[in])
            return null;
        TreeNode curr=new TreeNode(preorder[pre]);
        pre++;
        stack.push(curr.val);
        if(root==null)
            root=curr;
        //check if we can explore the left
        if(stack.peek()!=inorder[in])
            curr.left=build(preorder,inorder);
        if(stack.peek()==inorder[in]){
            //left cannot be explored
            stack.pop();
            in++;
            curr.right=build(preorder,inorder);
            // check if right can be explored
            // if(in<preorder.length-1 && !stack.contains(preorder[in+1])){
            //     in++;
            //     curr.right=build(preorder,inorder);
            // }
        }
        return curr;
    }
}
