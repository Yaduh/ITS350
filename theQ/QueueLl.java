package theQ;

public class QueueLl {
        private Node front;
        private Node rear;
    
        public QueueLl() {
            this.front = this.rear = null;
        }
    
        public boolean isEmpty() {
            return front == null;
        }
    
        public void enqueue(int value) {
            Node newNode = new Node(value);
            if (isEmpty()) {
                front = rear = newNode;
            } else {
                rear.next = newNode; // set pointer of current node to new data block -- pointer is set
                rear = newNode; // set rear to new node that is pointed to by the last node
            }
            System.out.println("Enqueued element: " + value);
        }
    
        public int dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            int value = front.data; // copy front value
            front = front.next; // set front to the next item in queue
            if (front == null) {
                rear = null; // Reset rear if front becomes null
            }
            return value;
        }
    
        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }
            Node current = front;
            System.out.print("Queue: ");
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public static void main(String[] args) {
            QueueLl queue = new QueueLl();
    
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.display();
    
            int dequeuedElement = queue.dequeue();
            System.out.println("Dequeued element: " + dequeuedElement);
    
            queue.display();
        }

    }
     
    

