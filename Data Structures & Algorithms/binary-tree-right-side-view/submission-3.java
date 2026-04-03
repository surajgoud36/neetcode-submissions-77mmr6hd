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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root==null)
            return res;
        Deque<TreeNode> queue=new ArrayDeque<>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            res.add(queue.peek().val);
            for(int i=0;i<len;i++){
                TreeNode t=queue.removeFirst();
                //res.add(t.val);
                if(t.right!=null){
                    queue.addLast(t.right);
                }
                if(t.left!=null)
                    queue.addLast(t.left);
                    
            }
        }
        return res;
    }
}
