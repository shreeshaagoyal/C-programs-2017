import java.util.List;
import java.util.LinkedList;

public class Queue {
    List<Integer> queue = new LinkedList<Integer>();
    public void add(int e) {
        this.queue.add(0, e);
    }
    public int remove() {
        int result = this.peek();
        this.queue.remove(this.queue.size()-1);
        return result;
    }
    public int size() {
        return this.queue.size();
    }
    public int peek() {
        return this.queue.get(this.queue.size()-1);
    }
}