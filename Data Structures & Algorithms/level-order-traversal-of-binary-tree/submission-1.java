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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        Deque<TreeNode> queue=new ArrayDeque<>();
        if(root==null)
            return res;
        queue.addLast(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode t=queue.removeFirst();
                if(t.left!=null)
                    queue.addLast(t.left);
                if(t.right!=null)
                    queue.addLast(t.right);
                
                temp.add(t.val);
            }
            res.add(temp);
        }
        return res;

    }
}
