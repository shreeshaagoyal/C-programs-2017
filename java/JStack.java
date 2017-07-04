public class JStack {
    List<Integer> lastElement;
    List<Integer> stack = new LinkedList<Integer>();
    int size;
    public void push(int e) {
        this.stack.add(e);
    }
    public int pop() {
        this.size = this.stack.size();
        this.stack.remove(this.size-1);
        return this.stack.get(this.size-1);
    }
    public int size() {
        return this.stack.size();
    }
    public int peek() {
        return this.stack.get(this.size-1);
    }
}