import java.util.List;
import java.util.LinkedList;
public class JStack {
    List<Integer> stack = new LinkedList<Integer>();
    List<Integer> minStack = new LinkedList<Integer>();
    
    public JStack(int e) {
        this.minStack.add(e);
        this.stack.add(e);
    }
    public void push(int e) {
        if(e < min()) {
            this.minStack.add(e);
        }
        this.stack.add(e);
    }
    public int pop() {
        int result = peek();
        if(result == min()) {
            this.minStack.remove(this.minStack.size()-1);
        }
        this.stack.remove(this.stack.size()-1);
        return result;
    }
    
    public int min() {
        return this.minStack.get(this.minStack.size()-1);
    }

    /** PRIVATE METHODS */
    private int peek() {
        return this.stack.get(this.stack.size()-1);
    }
}