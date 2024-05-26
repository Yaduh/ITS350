package stacks;

public class Stack {
    private int maxSize;
    private int[] stackArray;
    private int top;

    // Constructor to initialize the stack
    public Stack(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1; // Stack is initially empty
    }

    // Method to push an element onto the stack
    public void push(int num) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        stackArray[++top] = num;
        System.out.println("'" + num + "' has been pushed onto the stack.");
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Stack is empty");
            return -1;
        }
        int value = stackArray[top];
        stackArray[top] = 0;
        top--;
        return value;
    }

    
    // Method to pop an element from the stack
    public void delBottom() { // remove outdated call. (older than 10 past calls)
        if (isEmpty()) {
            System.out.println("Error: Stack is empty.");
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
            System.out.println("Error: Stack is empty. Cannot peek at the top element.");
            return -1;
        }
        return stackArray[top];
    }

    // Method to display the elements of the stack
    public void display() {
        System.out.println("Elements in the stack:");
        for (int i = top; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public static void main(String[] args) {
        // Create a stack with a maximum size of 5
        Stack stack = new Stack(10);

        // Push elements onto the stack
        stack.push(6);
        stack.push(5);
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        
        // Display the stack
        stack.display();

        // Peek at the top element
        System.out.println("Top element: " + stack.peek());
        stack.pop();
        stack.pop();

        // Display the stack after popping elements
        stack.display();
        System.out.println("Top element: " + stack.peek());
    }
}
