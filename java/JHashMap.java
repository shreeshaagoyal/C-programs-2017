public class JHashMap {
    Bucket[] hashMap;
    public JHashMap(int hashMapSize) {
        this.hashMap = new Bucket[hashMapSize];
    }
    public void setHashMap(String key, int value) {
        this.hashMap.get(this.hashMap.calculateIndex(key, this.hashMap.size())).addInBucket(key, value);
    }
    public int getHashMap(String key) {
        this.hashMap.get(this.calculateIndex(key)).getInBucket(key, );
    }
    public int calculateIndex(String key) {
        return key.hashCode() % this.hashMap.size();
    }
}