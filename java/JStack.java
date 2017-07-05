public class JStack {
    List<Integer> stack = new LinkedList<Integer>();
    public void push(int e) {
        this.stack.add(e);
    }
    public int pop() {
        int result = peek();
        this.stack.remove(this.stack.size()-1);
        return result;
    }
    public int size() {
        return this.stack.size();
    }
    public int peek() {
        return this.stack.get(this.stack.size()-1);
    }
}
