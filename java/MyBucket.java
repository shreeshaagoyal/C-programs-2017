import java.util.ArrayList;

public class MyBucket {
    ArrayList<MyEntry> entries;

    public MyBucket() {
        this.entries = new ArrayList<MyEntry>();
    }

    public void add(String s, int n) {
        for (int i = 0; i < this.entries.size(); i++) {
            MyEntry currEntry = this.entries.get(i);
            if (currEntry.s.equals(s)) {
                currEntry.n = n;
                return;
            }
        }
        MyEntry newEntry = new MyEntry(s, n);
        this.entries.add(newEntry);
    }

    public int get(String s) {
        for (int i = 0; i < this.entries.size(); i++) {
            MyEntry currEntry = this.entries.get(i);
            if (currEntry.s.equals(s)) {
                return currEntry.n;
            }
        }
        throw new IllegalArgumentException("Key does not exist");
    }

    public void remove(String s) {
        for (int i = 0; i < this.entries.size(); i++) {
            MyEntry currEntry = this.entries.get(i);
            if (currEntry.s.equals(s)) {
                this.entries.remove(i);
            }
        }
    }

    public int size() {
        return this.entries.size();
    }

    public static void main(String[] args) {
        MyBucket testBucket = new MyBucket();
        testBucket.add("Shreeshaa", 19);
    }
}