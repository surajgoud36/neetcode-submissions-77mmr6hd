class WordDictionary {
    TrieNode root = null;

    public WordDictionary() {
      root = new TrieNode();
    }

    public void addWord(String word) {
      TrieNode curr = this.root;
      for (char c : word.toCharArray()) {
        if (!curr.map.containsKey(c)) {
          curr.map.put(c, new TrieNode());
        }
        curr = curr.map.get(c);
      }
      curr.word = true;
    }

    public boolean search(String word) {
      if (word.length() == 0)
        return true;
      TrieNode curr = this.root;
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == '.') {
          // boolean res=false;
           System.out.println(root.map);
          for (Character ch : curr.map.keySet()) {
            if (s2(word.substring(i+1), curr.map.get(ch)))
              return true;
          }
          return false;
        } else {
          if (!curr.map.containsKey(word.charAt(i)))
            return false;
          curr = curr.map.get(word.charAt(i));
        }

      }

      return curr.word;
    }

    public boolean s2(String word, TrieNode groot) {
      System.out.println(groot.map+" "+word);
    //   if (word.length() == 0 && groot.map.isEmpty())
    //         return true;
      TrieNode curr = groot;
      for (int i = 0; i < word.length(); i++) {
        if (word.charAt(i) == '.') {
          // boolean res=false;
          for (Character ch : curr.map.keySet()) {
            if (s2(word.substring(i+1 ), curr.map.get(ch)))
              return true;
          }
          return false;
        } else {
          if (!curr.map.containsKey(word.charAt(i)))
            return false;
          curr = curr.map.get(word.charAt(i));
        }

      }

      return curr.word;
    }
  }

  class TrieNode {
    boolean word;
    Map<Character, TrieNode> map = new HashMap<>();
  }