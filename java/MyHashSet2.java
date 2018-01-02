public class MyHashSet2 {
    MyHashMap hashSet;
    public MyHashSet2(int n) {
        this.hashSet = new MyHashMap(n);
    }

    public void add(String s) {
        this.hashSet.put(s, 0);
    }

    public void remove(String s) {
        this.hashSet.remove(s);
    }

    public Boolean contains(String s) {
        return this.hashSet.containsKey(s);
    }

    public int size() {
        return this.hashSet.size();
    }

    public static void main(String[] args) {
        MyHashSet2 testSet = new MyHashSet2(2);
        testSet.add("lol");
        testSet.add("loll");
        testSet.add("loll");
        testSet.remove("loll");

        System.out.println("lol : " + testSet.contains("lol"));
        System.out.println("loll : " + testSet.contains("loll"));
        System.out.println("lolll : " + testSet.contains("lolll"));
        
    }
}