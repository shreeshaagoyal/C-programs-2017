import java.util.LinkedList;

public class Bucket {
    private List<Entry> bucket;
    public Bucket() {
        this.bucket = new LinkedList<Entry>();
    }
    public void addInBucket(String key, int value) {
        Entry newEntry = new Entry(key, value);
        this.bucket.add(newEntry);
    }
}