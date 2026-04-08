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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Queue<TreeNode> queue=new ArrayDeque<>();
        boolean left=true;
        queue.add(root);
        while(!queue.isEmpty()){
            int len=queue.size();
            List<Integer> level=new ArrayList<>();
            for(int i=0;i<len;i++){
                TreeNode temp=queue.poll();
                level.add(temp.val);
                if(temp.left!=null)
                    queue.add(temp.left);
                if(temp.right!=null)
                    queue.add(temp.right);
                
            }
            if(left)
                res.add(level);
            else{
                Collections.reverse(level);
                res.add(level);
            }
            left=!left;
        }
        return res;
    }
}