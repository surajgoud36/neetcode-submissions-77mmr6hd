class FreqStack {
    Map<Integer,Integer> eleFrequency;
    Map<Integer,Deque<Integer>> freqStack;
    int maxFreq;
    public FreqStack() {
        eleFrequency=new HashMap<>();
        freqStack=new HashMap<>();
        maxFreq=0;
    }
    
    public void push(int val) {
        int fr=eleFrequency.getOrDefault(val,0)+1;
        eleFrequency.put(val,fr);
        freqStack.computeIfAbsent(fr,k-> new ArrayDeque<>()).push(val);
        maxFreq=Math.max(maxFreq,fr);
    }
    
    public int pop() {
        int ele=freqStack.get(maxFreq).pop();
        eleFrequency.put(ele,eleFrequency.get(ele)-1);
        if(freqStack.get(maxFreq).isEmpty())
            maxFreq--;
        return ele;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */