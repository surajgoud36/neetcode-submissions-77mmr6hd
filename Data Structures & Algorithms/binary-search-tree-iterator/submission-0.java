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
class BSTIterator {
    TreeNode root=null;
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        this.root=root;
        stack = new ArrayDeque<>();
    }
    
    public int next() {
        if(root!=null){
            stack.push(root);
            root=root.left;
            return next();
        }
        else{
            TreeNode node=stack.pop();
            if(node.right!=null)
                root=node.right;
            return node.val;
        }
    }
    
    public boolean hasNext() {
        // we return false when the root is null and also the stack is null 
        if(root==null && stack.size()==0)
            return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */