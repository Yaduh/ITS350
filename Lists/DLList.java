package Lists;
public class DLList {
    Node tail;
    Node head;
    int size = 0;
    void addF(int data){ //add first
        Node node = new Node(data);
        if(head == null){
            head = tail = node; //head = new node, tail = new node;
            head = null;
            tail = null;
            size++;
        }
        else{
            node.next = head; // [node(->head), head]
            head.prev = node; // [node(-> head), (node<-)head]
            head = node; // [head(-> node), (<-head)node]
            size++;
        }
    }

    void addL(int data){
        Node node = new Node(data);
        if(head == null){
            head = tail = node; //head = new node, tail = new node;
            size++;
        }
        else{
            tail.next = node; // [tail(->node) ,(tail<-)node] [node(-> head), (node<-)head]
            node.prev = tail; // [tail ,(tail<-)node]
            tail = node; // [node(-> tail), (<-node)tail]
            size++;
        }
    }

    void addAt(int data, int index){
        Node node = new Node(data);
        if(head==null){
            head = tail = node; // If the list is empty, the new node becomes both head and tail
            size++;
            return;
            }
        if(index == 1){
            addF(data);
            return;
            }
        if(index == size + 1){
            addL(data);
            return;
            }
        int count = 1;
        Node tempHead = head; // make a copy of head node
        while(count <index-1){
            tempHead = tempHead.next; // tempHead(->tempNode) temp
            count++;
        }
        // add new node
        Node node2 = tempHead.next; // [node2.next , node2, (<-node2)tempHead]
        tempHead.next = node; //[node2, (node2<-)]
        node.next = node2;
        node2.prev = node;
        node.prev = tempHead;
        size++;
    }

    void deleteL(){
        if(tail == head){
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }
    void deleteF(){
        if(head == tail){ // if theres one element in the list
            return; //return nothing
        }
        head = head.next; // [head(->node), (head<-)node] | head = node
        head.prev = null; // [null , (head<-)head]
        size--;
    }
    void deleteAt(int index) {
        if (index < 1 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 1) {
            deleteF();
            return;
        }

        if (index == size) {
            deleteL();
            return;
        }

        int count = 1;
        Node tempHead = head;
        while (count < index) {
            tempHead = tempHead.next;
            count++;
        }

        tempHead.prev.next = tempHead.next;
        tempHead.next.prev = tempHead.prev;
        size--;
    }

    

    void rDisplay(){ //reverse display
        if (head == null){
            System.out.println("Empty");
        }else{
            Node current = tail; //start from tail (make a copy of data in tail)
            while(current != null){
                System.out.print(current.data + " ");
                current = current.prev; //iterate through the copy of the list
            }
        }
    }

    public static void main(String[] args) {
        DLList list = new DLList();
        list.addF(2);
        list.addF(6);
        list.addF(1);
        list.addL(9);
        list.addAt(8,5);
        list.deleteF();
        list.deleteL();
        list.rDisplay();
    }
}