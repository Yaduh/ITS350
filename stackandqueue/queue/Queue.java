import package Lists;

package queue;
public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int currentSize;

    // Constructor
    public Queue(int size) {
        this.maxSize = size;
        this.queueArray = new int[maxSize];
        this.front = -1;
        this.rear = -1;
        this.currentSize = 0;
    }

    // Insert element at the rear of the queue
    public void enqueue(int value) {
        if (!isFull()) { // Check if the queue is not full
            if (rear == maxSize - 1) {
                System.out.println("Queue is full. Cannot enqueue element.");
            } else {
                if (front == -1) {
                    front = 0; // Set front to 0 if it is pointing to -1 (initial state)
                }
                rear++;
                queueArray[rear] = value;
                currentSize++;
                System.out.println("Enqueued element: " + value);
            }
        } else {
            System.out.println("Queue is full. Cannot enqueue element.");
        }
    }
    

    // Remove element from the front of the queue
    public int dequeue() {
        int value;
        if (isEmpty()) {
            return -1; // Return -1 if the queue is empty
        } else {
            value = queueArray[front]; // Get the value at the front of the queue
            if (currentSize == 1) { // Check if there's only one element in the queue
                front = -1; // Reset front to -1
                rear = -1; // Reset rear to -1
            } else {
                front++; // Increment front to remove the front element
            }
            currentSize--; // Decrement the current size of the queue
            return value; // Return the value that was dequeued
        }
    }
    

    // Peek operation
    public int peek() {
        if (!isEmpty()) {
            return queueArray[front];
        } else {
            System.out.println("Queue is empty. Cannot peek element.");
            return -1; // Return a default value to indicate failure
        }
    }

    // Check if queue is full
    public boolean isFull() {
        return (currentSize == maxSize);
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return (currentSize == 0);
    }

    // Display the queue
    public void display() {
        if (!isEmpty()) { // Check if the queue is not empty
            System.out.print("Queue: ");
            int i = front; // Start iterating from the front of the queue
            int count = 0; // Initialize count to track the number of elements displayed
            while (count < currentSize) { // Loop until count reaches the current size of the queue
                System.out.print(queueArray[i] + " "); // Print the element at index i in the queueArray
                i++; // Move to the next element in the queue
                count++; // Increment count
            }
            System.out.println(); // Print a new line after displaying all elements
        } else {
            System.out.println("Queue is empty."); // Print a message if the queue is empty
        }
    }
    

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Front =" + queue.front);
        System.out.println("Rear =" + queue.rear);
        queue.display();

        System.out.println("Peek: " + queue.peek());
        queue.dequeue();
        queue.display();
        System.out.println("Front =" + queue.front);
        System.out.println("Rear =" + queue.rear);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue(); // Trying to dequeue from empty queue
        queue.display();
        System.out.println("Front =" + queue.front);
        System.out.println("Rear =" + queue.rear);
    }
}

    // void enqueue(int data){
    //     Node node = new Node(data);
    //     if(isEmpty()){
    //         front = back = node;
    //     }else{
    //         back.next = node;
    //         back = node;

    //     }
    //     length++;
    // }
    // int dequeue(){
    //     if(isEmpty){
    //         System.out.println("MT");
    //         return -1;
    //     }else{
            
    //     }
    // }

    