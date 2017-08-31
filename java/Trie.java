import java.util.HashMap;
public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word, int value) {
        HashMap<TrieValue, TrieNode> children = root.children;

        for(int i = 0; i < word.length(); i++) {
            TrieValue c = new TrieValue(word.charAt(i));
            if(!children.containsKey(c)) {
                TrieNode t = new TrieNode();
                children.put(c, t);
            }
            children = children.get(c).children;
        }
        // set leaf node
        TrieValue num = new TrieValue(value);
        children.put(num, null);
    }
    public int search(String word) {
        return 0;
    }
    public void delete(String word) {

    }
}