import java.util.HashMap;
public class MyTrieNode {
    Character c;
    Boolean isSentinel;
    HashMap<Character, MyTrieNode> nextAlphabets;

    public MyTrieNode() {
        this.isSentinel = false;
        this.nextAlphabets = new HashMap<Character, MyTrieNode>();
    }

    public MyTrieNode(char c) {
        this.c = c;
        this.isSentinel = false;
        this.nextAlphabets = new HashMap<Character, MyTrieNode>();
    }

    public MyTrieNode(char c, Boolean isSentinel) {
        this.c = c;
        this.isSentinel = isSentinel;
        this.nextAlphabets = new HashMap<Character, MyTrieNode>();
    }
}