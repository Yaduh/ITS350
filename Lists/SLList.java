package Lists;
public class SLList{

        public Node head; // [HEAD, NODE, NODE, TAIL]
        public Node tail;
        int size; // SIZE = 4

        public void addFirst(int data){ // add to start of list
            Node newNode = new Node(data); // create node object
            if (head == null){ // if list empty -> newNode object is both head and tail
                head = tail = newNode;
                return;
            }
                newNode.next = head;
                head = newNode;
            size++;
        }

        void addLast(int data){
            Node newNode = new Node(data);
            if (head == null){
                head = tail = newNode;
            }
            else{
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        void addAt(int data, int pos) {
            if (pos < 1 || pos > size + 1) {
                System.out.println("Enter a valid position");
                return;
            }
            if (pos == 1) {
                addFirst(data);
                return;
            }
    
            if (pos == size + 1) {
                addLast(data);
                return;
            }
    
            Node newNode = new Node(data);
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
            size++;
        }
    
        void deleteFirst(){
            if(head==null){
                System.out.println("Empty");
            }else{
                head = head.next;
                size--;
            }
        }
        void deleteLast() {
            if (head == null) {
                System.out.println("Empty");
                return;
            }
            if (head == tail) { // Only one element in the list
                head = tail = null;
            } else {
                Node temp = head;
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
            }
            size--;
        }

        void deleteAt(int pos) {
            if (pos < 1 || pos > size) {
                System.out.println("Enter a valid position");
            }
    
            if (pos == 1) {
                deleteFirst();
                return;
            }
    
            if (pos == size) {
                deleteLast();
                return;
            }
    
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
    
        void display(){
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data + " ");
                temp = temp.next; 
            }
            System.out.println();
        }
        public static void main(String args[]) {
            SLList list = new SLList();
            list.display();
            list.addFirst(5);
            list.addFirst(10);
            list.display();
            list.addLast(11);
            list.display();
            list.addFirst(12);
            list.display();

        }
    }