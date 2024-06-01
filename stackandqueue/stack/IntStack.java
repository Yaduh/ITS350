
public class IntStack {
    private int[] stackArray;
    private int top;
    private int size;

    // Constructor to initialize the stack
    public IntStack(int size) {
        this.size = size;
        stackArray = new int[size];
        top = -1; // Stack is initially empty
    }

    // Method to push an element onto the stack
    public void push(int num) {
        if (isFull()) {
            return;
        }
        top++;
        stackArray[top] = num;
    }

    public int pop(){
        if(isEmpty()){
            return -1;
        }
        top--;
        return stackArray[top];
    }

    
    // Method to pop an element from the stack
    public void delBottom() { // remove outdated call. (older than 10 past calls)
        if (isEmpty()) {
            return;
        }
        for (int i = 0; i < top; i++) {
            stackArray[i] = stackArray[i + 1];
        }
        top--;
    }

    // Method to peek at the top element of the stack
    public int peek() {
        if (isEmpty()) { 
            return 0;
        }
        return stackArray[top];
    }

    // Method to display the elements of the stack
    public void display() {
        System.out.println("Elements in the stack:");
        for (int i = size-1; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        if(top < 0){
            System.out.println("Stack is empty.");
            return true;
    }
        return false;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        if(top >= size - 1){
            System.out.println("Stack is full");
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        // Create a stack with a maximum size of 5
        IntStack stack = new IntStack(10);

        // Push elements onto the stack
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.pop();
        stack.push(3);
        System.out.println("Peek: " + stack.peek());        
        // Display the stack
        stack.display();

        // Display the stack after popping elements
    }
    }

