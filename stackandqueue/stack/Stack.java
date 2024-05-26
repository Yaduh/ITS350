package stack;

public class Stack {
    private int[] stackArray;
    private int top;
    private int size;

    // Constructor to initialize the stack
    public Stack(int size) {
        this.size = size;
        stackArray = new int[size];
        top = -1; // Stack is initially empty
    }

    // Method to push an element onto the stack
    public void push(int num) {
        if (isFull()) {
            System.out.println("Stack overflow");
            return;
        }
        top++;
        stackArray[top] = num;
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
        for (int i = size-1; i >= 0; i--) {
            System.out.println(stackArray[i]);
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top < 0);
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return (top > size - 1);
    }

    boolean palindrome(String word){
        for(int i = 0; i<word.length(); i++){
            push(word.charAt(i));
        }
            String str = " ";
            for(int i = 0; i<word.length(); i++){
                str = str + pop();
            }
            return word.equalsIgnoreCase(str);
        }
    }

