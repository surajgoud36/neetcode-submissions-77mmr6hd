class Node{
    int val,key,freq;
    public Node(int key,int val,int freq){
        this.val=val;
        this.key=key;
        this.freq=freq;
    }
}
class LFUCache {
    Map<Integer,Node> nodeMap;
    Map<Integer,LinkedList<Node>> freqMap;
    int minFreq,capacity;
    public LFUCache(int capacity) {
        this.capacity=capacity;
        minFreq=1;
        nodeMap=new HashMap<>();
        freqMap=new HashMap<>();
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key))
            return -1;
        Node curr=nodeMap.get(key);
        increaseFrequency(curr);
        // Node curr=nodeMap.get(key);
        // int oldFreq=curr.freq;
        // int newFreq=oldFreq+1;
        // curr.freq++;
        // freqMap.computeIfAbsent(newFreq,k -> new LinkedList<>());
        // LinkedList<Node> oldList=freqMap.get(oldFreq);
        // LinkedList<Node> newList=freqMap.get(newFreq);
        // oldList.remove(curr);
        // newList.addFirst(curr);
        // if(minFreq==oldFreq && oldList.isEmpty())
        //     minFreq++;
        return curr.val;
    }
    
    public void put(int key, int value) {
        if(!nodeMap.containsKey(key)){
            // key not there, so check for capacity
            Node node=new Node(key,value,1);
            if(nodeMap.size()==capacity){
                // evict one node
                LinkedList<Node> list=freqMap.get(minFreq);
                Node removed=list.removeLast();
                minFreq=1;
                nodeMap.remove(removed.key);
                
                freqMap.get(minFreq).addFirst(node);
                nodeMap.put(key,node);
            }
            else{
                minFreq=1;
                freqMap.computeIfAbsent(minFreq,k -> new LinkedList<>()).addFirst(node);
                nodeMap.put(key,node);
            }
        }
        else{
            // we need to update the frequency and the value
            Node curr=nodeMap.get(key);
            curr.val=value;
            increaseFrequency(curr);
        }
    }
    public void increaseFrequency(Node curr){
        int oldFreq=curr.freq;
        int newFreq=oldFreq+1;
        curr.freq++;
        freqMap.computeIfAbsent(newFreq,k -> new LinkedList<>());
        LinkedList<Node> oldList=freqMap.get(oldFreq);
        LinkedList<Node> newList=freqMap.get(newFreq);
        oldList.remove(curr);
        newList.addFirst(curr);
        if(minFreq==oldFreq && oldList.isEmpty())
            minFreq++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */