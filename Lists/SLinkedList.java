package Lists;
public class SLinkedList{

        public Node head; // [HEAD, NODE, NODE, TAIL]
        public static Node tail;
        int size = 0; // SIZE = 4

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
        void display(){
            Node temp = head;
            while(temp != null){
                System.out.println(temp.data + " ");
                temp = temp.next; 
            }
            System.out.println();
        }
        public static void main(String args[]) {
            SLinkedList list = new SLinkedList();
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