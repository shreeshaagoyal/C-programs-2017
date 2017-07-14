import java.util.LinkedList;

public class Bucket {

    private List<Entry> entries;

    public Bucket() {
        this.entries = new LinkedList<Entry>();
    }

    public void setInBucket(String key, int value) {
        for(int i = 0; i < size(); i++) {
            if(entries.get(i).key == key) {
                entries.get(i).value = value;
                return;
            }
        }

        Entry newEntry = new Entry(key, value);
        this.entries.add(newEntry);
    }

    public int size() {
       return entries.size();
    }

    public int getValue(String key) {
        for(int i = 0; i < size(); i++) {
            if(entries.get(i).key == key) {
                return entries.get(i).value;
            }
        }
        throw new RuntimeException("Key not found : " + key);
    }

}
