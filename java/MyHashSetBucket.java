import java.util.List;
import java.util.ArrayList;

public class MyHashSetBucket {
    List<Integer> entries;

    public MyHashSetBucket() {
        this.entries = new ArrayList<Integer>();
    }

    public void add(int n) {
        for (int i = 0; i < this.entries.size(); i++) {
            if (this.entries.get(i) == n) {
                return;
            }
        }
        entries.add(n);
    }

    public void remove(int n) {
        for (int i = 0; i < this.entries.size(); i++) {
            if (this.entries.get(i) == n) {
                this.entries.remove(i);
            }
        }
    }

    public Boolean contains(int n) {
        for (int i = 0; i < this.entries.size(); i++) {
            if (this.entries.get(i) == n) {
                return true;
            }
        }
        return false;
    }

    public int numEntries() {
        return this.entries.size();
    }
}