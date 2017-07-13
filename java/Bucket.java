import java.util.LinkedList;

public class Bucket {
    public Bucket() {
        List<Entry> bucket = new LinkedList<Entry>();
    }
    public void addInBucket(String key, int value) {
        Entry newEntry = new Entry(key, value);
        bucket.add(newEntry);
    }
}