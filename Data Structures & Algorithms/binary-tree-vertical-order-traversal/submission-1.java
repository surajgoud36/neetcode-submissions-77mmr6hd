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
record Pair(TreeNode root,int lvl){}
class Solution {
    int min,max;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        min=0;max=0;
        List<List<Integer>> res=new ArrayList<>();
        if(root==null)
            return res;
        Map<Integer,List<Integer>> map=new HashMap<>();
        Queue<Pair> queue = new ArrayDeque<>();
        queue.add(new Pair(root,0));
        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                Pair curr = queue.poll();
                TreeNode currNode=curr.root();
                int col=curr.lvl();
                map.computeIfAbsent(col,k->new ArrayList<>()).add(currNode.val);
                min=Math.min(min,col);
                max=Math.max(max,col);
                if(currNode.left!=null)
                    queue.add(new Pair(currNode.left,col-1));
                 if(currNode.right!=null)
                    queue.add(new Pair(currNode.right,col+1));
            }
        }
        //int level=0;
        //dfs(map,root,0);
        for(int i=min;i<=max;i++){
            res.add(map.get(i));
        }
        return res;
    }   
    public void dfs(Map<Integer,List<Integer>> map,TreeNode root,int level){
        if(root==null)
            return;
        min=Math.min(min,level);
        max=Math.max(max,level);
        map.computeIfAbsent(level,k->new ArrayList<>()).add(root.val);
        dfs(map,root.left,level-1);
        dfs(map,root.right,level+1);
    }
}