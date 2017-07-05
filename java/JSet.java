public class JSet {
    JMap map = new JMap();
    public void add(String key) {
        map.set(key, 0);
    }
    public boolean contains(String key) {
        try {
            map.get(key);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}