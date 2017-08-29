public class Bucket2 {
    Entry2[] bucket = new Entry2[0];
    public Bucket2() {
    }
    public void setInBucket(String key, int value) {
        for(int i = 0; i < bucket.length; i++) {
            if(bucket[i].key == key) {
                bucket[i].value = value;
                return;
            }
        }
        Entry2 newEntry = new Entry2(key, value);
        try {
            bucket[bucket.length] = newEntry;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            Entry2[] newBucket = new Entry2[bucket.length + 1];
            for(int i = 0; i < bucket.length; i++) {
                newBucket[i] = bucket[i]; // copying elements from original array to new array
            }
            newBucket[bucket.length] = newEntry;
            bucket = newBucket;
            newBucket = null;
        }
    }

    public int getFromBucket(String key) {
        for(int i = 0; i < bucket.length; i++) {
            if(bucket[i].key == key) {
                return bucket[i].value;
            }
        }
        throw new IllegalArgumentException();
    }

    public void removeFromBucket(String key) {
        Entry2[] newBucket = new Entry2[bucket.length - 1];
        int j = 0;
        for(int i = 0; i < bucket.length; i++) {
            if(bucket[i].key == key) {
                continue;
            }
            newBucket[j] = bucket[i];
            j++;
        }
        bucket = newBucket;
        newBucket = null;
    }
}