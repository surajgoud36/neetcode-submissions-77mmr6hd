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
    public List<Integer> postorderTraversal(TreeNode root) {
        Set<TreeNode> visit = new HashSet<>();
        List<Integer> res= new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        if(root==null)
            return res;
        TreeNode curr = root;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){
                visit.add(curr);
                stack.push(curr);
                if(curr.right!=null)
                    stack.push(curr.right);
                curr=curr.left;
            }
            else{
                TreeNode temp=stack.pop();
                if(!visit.contains(temp)){
                    stack.push(temp);
                    visit.add(temp);
                    if(temp.right!=null)
                        stack.push(temp.right);
                    curr=temp.left;
                }
                else{
                    res.add(temp.val);

                }
            }
        }
        return res;
    }
}