public class TrieValue {
    private Character c = null;
    private Integer value = null;
    public TrieValue(char c) {
        this.c = c;
    }
    public TrieValue(int value) {
        this.value = value;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TrieValue)) {
            return false;
        }

        TrieValue tv = (TrieValue) obj;
        if((this.c == tv.c) && (this.value == tv.value)) {
            return true;
        } else {
            return false;
        }
    }

    public int hashCode() {
        if(this.c == null) {
            return this.value.intValue();
        } else {
            return (int) this.c.get;
        }
    }
}