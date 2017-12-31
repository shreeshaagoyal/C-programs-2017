public class MyTrie {
    MyTrieNode root;

    // addWord
    // containsWord
    // containsPrefix

    public MyTrie() {
        this.root = new MyTrieNode();
    }

    public void addWord(String word) {
        MyTrieNode currNode = this.root;
        for (int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if (currNode.nextAlphabets.containsKey(currChar)) {
                currNode = currNode.nextAlphabets.get(currChar);
            } else {
                MyTrieNode newNode = new MyTrieNode(currChar);
                currNode.nextAlphabets.put(currChar, newNode);
                currNode = newNode;
            }
        }

        if (currNode != this.root) {
            currNode.isSentinel = true;
        }
    }

    public Boolean containsPrefix(String s) {
        if (getPrefixEndNode(s) == null) {
            return false;
        } else {
            return true;
        }
    }

    private MyTrieNode getPrefixEndNode(String s) {
        MyTrieNode currNode = this.root;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currNode.nextAlphabets.containsKey(currChar)) {
                currNode = currNode.nextAlphabets.get(currChar);
            } else {
                return null;
            }
        }
        return currNode;
    }

    public Boolean containsWord(String word) {
        MyTrieNode endNode = getPrefixEndNode(word);
        if (endNode.isSentinel) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        MyTrie testTrie = new MyTrie();
        testTrie.addWord("art");
        testTrie.addWord("cat");
        testTrie.addWord("sam");
        testTrie.addWord("air");
        System.out.println(testTrie.containsPrefix("s"));
    }

}