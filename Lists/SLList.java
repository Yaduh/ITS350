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
            }else{
                // initial state: [CURRENT HEAD][NODE][TAIL]
                newNode.next = head; // point the new node to the current head
                // [NEW NODE]->[CURRENT HEAD][NODE][TAIL]
                
                head = newNode; // assign the new head
                // the current head is not over written but is now the second node in the list
                // [HEAD][NODE][NODE][TAIL]
            }
            size++;
        }

        void addLast(int data){
                // initial state: [HEAD][NODE][CURRENT TAIL]
            Node newNode = new Node(data);
            if (head == null){
                head = tail = newNode;
            }
            else{
                tail.next = newNode; // point the tail to the new node
                tail = newNode; // assign the tail to the new nodes position
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
            Node temp = head; // traversal node
            
            // Initial state: [Head][Node: 2][Node: 3][Tail]
            // Ex: insert a node at pos 3
            
            for (int i = 1; i < pos - 1; i++) { // move to the correct position
                temp = temp.next;
            }
            // temp is now "Node: 2"
            newNode.next = temp.next; // set the new node to point to Node: 2's next node  
            temp.next = newNode; // point node: 2 to the new node.
            size++;
        }
    
        void deleteFirst(){
            if(head==null){
                System.out.println("Empty");
            }else{
                head = head.next; // assign head to the next node
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
                Node temp = head; // traversal node
                while (temp.next != tail) { // traverse through the list until temp points to tail
                    temp = temp.next;
                }
                temp.next = null; // set pointer to null
                tail = temp; // assign new tail
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
            // Initial state: [Head][Node: 2][Node: 3][Tail]
            // Ex: delete the node at pos 2
            Node temp = head;
            for (int i = 1; i < pos - 1; i++) {
                temp = temp.next;
            }
            // temp = [head]
            temp.next = temp.next.next; // point temp node to the node thats after the deleted node
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