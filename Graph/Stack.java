public class Stack {
    private int[] st;
    private int top;
    // -----------------------------------------------------------
    public Stack(int size){ // constructor
        st = new int[size]; // make array
        top = -1;
    }
    // -----------------------------------------------------------
    public void push(int j){ // put item on stack
        st[++top] = j; 
    }
    // -----------------------------------------------------------
    public int pop(){ // take item off stack
        return st[top--]; 
    }
    // ------------------------------------------------------------
    public int peek(){ // peek at top of stack
        return st[top]; 
    }
    public boolean isEmpty(){// true if nothing on stack-
        return (top == -1); 
    }
}
