package queue;
public class Node {
    public int data;
    public Node next;
    public Node prev;

    Node(int data){ // Node Object
        this.data = data; // data = the parameter 'data'
        next = null;
        prev = null;
    }

}