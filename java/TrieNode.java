import java.util.HashMap;
public class TrieNode {
    TrieValue value;
    HashMap<TrieValue, TrieNode> children = new HashMap<TrieValue, TrieNode>();
    public TrieNode() {}
    public TrieNode(TrieValue value) {
        this.value = value;
    }
}