class Solution {
	TrieNode root;
	Map < Integer, Integer > dp;
	public int minExtraChar(String s, String[] dictionary) {
		root = build(dictionary);
		dp = new HashMap<> ();
		int res = minExtra(0,s);
		//System.out.println(dp);
		return res;
	}
	public int minExtra(int ind,String s) {
		if(dp.containsKey(ind)) return dp.get(ind);
		//System.out.println(s);
		TrieNode curr = root;
		int min = Integer.MAX_VALUE;
		for(int i = ind; i < s.length(); i++) {
			char c = s.charAt(i);
			if(!curr.children.containsKey(c)) {
				min = Math.min(min, minExtra(ind+1,s) + (1));
				//dp.put(ind, Math.min(s.length()-ind, min));
                dp.put(ind,min);
				//return Math.min(s.length()-ind, min);
                return min;
			}
			curr = curr.children.get(c);
			if(curr.word) {
				// if its an end of the word
				min = Math.min(min, minExtra(i+1,s));
			}
		}
		if(curr.word) {
			dp.put(ind, 0);
			return 0;
		}
		//better store it
		dp.put(ind, Math.min(s.length()-ind, min));
		return Math.min(s.length()-ind, min);
	}
	public TrieNode build(String[] dictionary) {
		TrieNode nRoot = new TrieNode();
		for(String word: dictionary) {
			insert(word, nRoot);
		}
		return nRoot;
	}
	public void insert(String word, TrieNode cRoot) {
		TrieNode curr = cRoot;
		for(char c: word.toCharArray()) {
			if(!curr.children.containsKey(c)) curr.children.put(c, new TrieNode());
			curr = curr.children.get(c);
		}
		curr.word = true;
	}
}
class TrieNode {
	Map < Character, TrieNode > children;
	boolean word;
	public TrieNode() {
		word = false;
		children = new HashMap < > ();
	}
}
