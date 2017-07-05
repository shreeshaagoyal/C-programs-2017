import java.util.ArrayList;
import java.util.List;
public class JMap {
    List<Entry> entryList = new ArrayList<Entry>();
    public void set(String key, int value) {
        for(int i = 0; i < this.entryList.size(); i++) {
            if(key == this.entryList.get(i).key) {
                // Replacing Entry
                this.entryList.get(i).value = value;
                return;
            }
        }
        // Adding new Entry to back
        Entry newEntry = new Entry(key, value);
        this.entryList.add(newEntry);
    }
    public int get(String key) {
        for(int i = 0; i < this.entryList.size(); i++) {
            if(key == this.entryList.get(i).key) {
                return entryList.get(i).value;
            }
        }
        throw new RuntimeException("Key doesn't exist.");
    }
}