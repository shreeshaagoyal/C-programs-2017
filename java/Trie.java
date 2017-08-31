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
            TrieNode t;
            if(children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new TrieNode(c);
                children.put(c, t);
            }
            children = t.children;
        }
        // set leaf node
        TrieValue num = new TrieValue(value);
        children.put(num, null);
    }
    public int search(String word) {
        HashMap<TrieValue, TrieNode> children = root.children;
        for(int i = 0; i < word.length(); i++) {
            TrieValue c = new TrieValue(word.charAt(i));
            if(children.containsKey(c)) {
                children = children.get(c).children;
                continue;
            } else {
                throw new IllegalArgumentException("Cannot find the given String.");
            }
        }
        
    }
    public void delete(String word) {

    }
}