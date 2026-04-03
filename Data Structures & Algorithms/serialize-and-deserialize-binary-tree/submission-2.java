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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null)
            return "";
        String res="",last="";
        Deque<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            if(node==null)
                res+="null ";
            else{
                res+=String.valueOf(node.val)+" ";
                last=String.valueOf(node.val);
                // if(node.left==null)
                //     queue.offer(new);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            //      
            
           

        }

        res=res.trim();
        res=res.substring(0,res.lastIndexOf(last)+last.length());
        System.out.println("my o/p: "+res+" last: "+last);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isEmpty())
            return null;

        String[] nodes=data.split("\\s+");
        Map<Integer,TreeNode> map = new HashMap<>();
        System.out.println(Arrays.toString(nodes));
        int main=0,child=1;
        TreeNode root=null,curr=null;
        for(int i=0;i<nodes.length;i++){
             if(nodes[i].equals("null"))
                continue;
            if(root==null){
                root=new TreeNode(Integer.parseInt(nodes[i]));
                curr=root;
                map.put(i,curr);
            }
            else{
                curr=map.get(i);
                //map.put(i,curr);
            }
             if(child<nodes.length){
                TreeNode child1=null,child2=null;
                if(nodes[child].equals("null"))
                     child1=null;
                else{
                     child1=new TreeNode(Integer.parseInt(nodes[child]));
                    map.put(child,child1);
                }
                curr.left=child1;
                child++;
                if(child==nodes.length)
                    break;
                if(nodes[child].equals("null"))
                     child2=null;
                else{
                     child2=new TreeNode(Integer.parseInt(nodes[child]));
                    map.put(child,child2);
                }
                child++;
                
                curr.right=child2;
            }
            else 
                break;
        }
        return root;
    }
}
