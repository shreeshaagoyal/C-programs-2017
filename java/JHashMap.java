public class JHashMap {
    Bucket[] hashMap;
    public JHashMap(int hashMapSize) {
        this.hashMap = new Bucket[hashMapSize];
    }
    public void setHashMap(String key, int value) {
        this.hashMap.get(this.hashMap.calculateIndex(key, this.hashMap.size())).addInBucket(key, value);
        if(calculateAverageBucketEntries >= 2) {
            Bucket[] temp = new Bucket[2 * this.hashMap.size()];
            for(int i = 0; i < this.hashMap.size(); i++) {
                for(int j = 0; j < this.hashMap.get(i).size(); j++) {
                    (this.hashMap.get(i)).get(j); // gets individual entry in original bucket
                }
            }
        }
    }
    public int getHashMap(String key) {
        for(int i = 0; i < this.hashMap.size(); i++) {
            if(this.hashMap.get(i).key == key) {
                return this.hashMap.get(i).value;
            }
        }
    }
    public int calculateIndex(String key) {
        return key.hashCode() % this.hashMap.size();
    }
    public int calculateAverageBucketEntries() {
        int sum = 0;
        for(int i = 0; i < this.hashMap.size(); i++) {
            sum += this.hashMap.get(i).size();
        }
        return sum/thishashMap.size();
    }
}