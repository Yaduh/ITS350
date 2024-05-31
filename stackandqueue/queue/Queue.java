package queue;

public class Queue {
    int queue[];
    int front;
    int rear;
    int count;
    public Queue(int size){
        queue = new int[size];
        front = -1;
        rear = -1;
    }
    void enqueue(int element){
        if(isEmpty()){
            front=0;
        }
        if(isFull()){
            System.out.println("Full!");
        }else{
            rear = (rear+1)%queue.length;
            queue[rear] = element;
            count++;
        }
    }
    boolean isEmpty(){
        return count==0;
    }
    boolean isFull(){
        return count==queue.length;
    }
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Empty");
        }else{
            int data = queue[front];
            queue[front] = 0;
            front = (front+1)%queue.length;
            count--;
            return data;
        }
        return -1;
    }
    void display(){
        for(int i=0; i<queue.length; i++)
            System.out.println(queue[i]);
    }
    public static void main(String args[]){
        Queue queue = new Queue(4);
        queue.enqueue(12);
        queue.enqueue(1);
        queue.enqueue(5);
        queue.display();
        System.out.println("------------------------------");
        queue.dequeue();
        queue.display();
        System.out.println("------------------------------");
        queue.enqueue(10);
        queue.display();
        System.out.println("------------------------------");
        queue.enqueue(3);
        queue.display();
        System.out.println("------------------------------");
        queue.dequeue();
        queue.display();
    }
}

    