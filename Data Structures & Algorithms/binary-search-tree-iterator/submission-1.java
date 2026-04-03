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
    TreeNode curr;
    Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        curr=root;
        stack=new ArrayDeque<>();
    }
    
    public int next() {
        while(curr!=null){
            stack.push(curr);
            curr=curr.left;
        }
        TreeNode temp = stack.pop();
        curr=temp.right;
        return temp.val;
    }
    
    public boolean hasNext() {
        if(curr==null && stack.isEmpty())
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