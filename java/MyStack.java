import java.util.List;
import java.util.ArrayList;
public class MyStack {
    List<Integer> stack;
    public MyStack() {
        stack = new ArrayList<Integer>();
    }
    public int size() {
        return this.stack.size();
    }
    public int peek() {
        int result = this.stack.get(this.stack.size() - 1);
        return result;
    }
    public int pop() {
        int result = this.peek();
        this.stack.remove(this.stack.size() - 1);
        return result;
    }
    public void push(int value) {
        this.stack.add(value);
    }
}