package stack;

public class Main {
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
