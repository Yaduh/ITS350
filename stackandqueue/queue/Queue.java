package queue;

public class Queue {
    Node front;
    Node rear;
    int length;
    
    void enqueue(int element){
        Node node = new Node(element);
        if(isEmpty()){
            front=rear=node;
        }else{
            rear.next = node;
            rear = node;  
        }
        length++;
    }
    boolean isEmpty(){
        return front==null;
    }
    public int dequeue(){
       if(isEmpty()){
           System.out.println("Empty!");
           return -1;
       } else{
           int data = front.data;
           front = front.next;
           length--;
           return data;
       }
    }
    void display(){
        if(!isEmpty()){
            Node temp = front;
            while(temp!=null){
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
    public static void main(String args[]){
        Queue queue = new Queue();
        queue.enqueue(10);
        queue.enqueue(12);
        queue.enqueue(4);
        queue.display();
        System.out.println("***************");
        int data = queue.dequeue();
        
        queue.display();
    }
}

    