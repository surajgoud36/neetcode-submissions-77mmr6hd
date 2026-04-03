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
        List<List<Integer>> list= new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        if(root==null)
            return list;
        queue.offer(root);
        int level=0;
        while(!queue.isEmpty()){
            List<Integer> l=new ArrayList<Integer>();
            int len=queue.size();
            for(int i=0;i<len;i++){
                TreeNode node=queue.peek();
                if(node.left!=null)
                    queue.offer(node.left);
                if(node.right!=null)
                    queue.offer(node.right);
                l.add(queue.poll().val);
            }
            list.add(l);
        }
        return list;
    }
}
