/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        // System.out.println("val= "+node.val);
        // //System.out.println("Neighbors= "+node.neighbors);
        // for(Node n:node.neighbors){
        //     System.out.print(n.val+" ");
        // }
        Node root=null;
        Map<Node,Node> visit=new HashMap<>();
        Queue<Node> queue=new ArrayDeque<>();
        return dfs(node,visit);
    }

    public Node dfs(Node node,Map<Node,Node> visit){
        Node newNode=new Node(node.val);
        visit.put(node,newNode);
        for(Node neigh:node.neighbors){
            if(visit.containsKey(neigh))
                newNode.neighbors.add(visit.get(neigh));
            else
                newNode.neighbors.add(dfs(neigh,visit));
        }
        return newNode;
    }
}