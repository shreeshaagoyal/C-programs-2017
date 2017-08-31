public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word, int value) {
        TrieNode curNode = root;
        for(int i = 0; i < word.length(); i++) {
            TrieValue c = new TrieValue(word.charAt(i));
            if(!curNode.children.containsKey(c)) {
                curNode.children.put(c, null);
            }
            curNode = curNode.children.get(c);
        }
        // set leaf node
        TrieValue num = new TrieValue(value);
        curNode.children.put(num, null);
    }
    public int search(String word) {
        return 0;
    }
    public void delete(String word) {

    }
}