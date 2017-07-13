import java.util.LinkedList;

public class Bucket {
    public Bucket() {
        List<Entry> bucket = new LinkedList<Entry>();
    }
    public void addInBucket(String key, int value) {
        Entry newEntry = new Entry(key, value);
        add(newEntry);
    }
    
    // MOVE THIS METHOD TO JHashMap CLASS
    public int getInBucket(String key, int index) {
        for(int i; i < bucket.size(); i++) {
            if(bucket.get(i) == key) {
                return bucket.get(i).value;
            }
        }
    }
}