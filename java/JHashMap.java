public class JHashMap {

    Bucket[] buckets;

    public JHashMap(int hashMapSize) {
        this.buckets = new Bucket[hashMapSize];
    }

    public void set(String key, int value) {
        Bucket bucket = this.buckets.get(calculateIndex(key));
        bucket.setInBucket(key, value);
        if(this.buckets.calculateAverageBucketEntries() >= 2) {
            decreaseBucketLoad();
        }
    }

    public int get(String key) {
        Bucket bucket = this.buckets.get(calculateIndex(key));
        return bucket.getValue(key);
    }

    /** PRIVATE METHODS **/

    private int calculateIndex(String key) {
        return key.hashCode() % this.buckets.length;
    }

    private int calculateAverageBucketEntries() {
        int sum = 0;
        for(int i = 0; i < this.buckets.length; i++) {
            sum += this.buckets.get(i).size();
        }
        return sum/this.buckets.length;
    }

    private void decreaseBucketLoad() {
        Bucket[] temp = new Bucket[2 * this.buckets.length];
        for(int i = 0; i < this.buckets.length; i++) {
            for(int j = 0; j < this.buckets.get(i).size(); j++) {
                int tempIndex = (this.buckets.get(i)).get(j).key.hashCode() % temp.length;
                (temp.get(tempIndex)).addInBucket(((this.buckets.get(i)).get(j)).key, ((this.buckets.get(i)).get(j)).value);
            }
        }
        this.buckets = temp;
    }

}
