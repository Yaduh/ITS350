package LinearSearch;
// import Lists.Node;
// import Lists.SLinkedList;
public class LinSearch{

    public static void main(String... args) {
        int array[] = {4,45,2};
        int value = linearSearchArr(array, 4);
        if(value != -1){
        System.out.println("Element found at index "+ value + ".");
    }else{
        System.out.println("Element not found.");
    }

        // SLinkedList list = new SLinkedList();
        // list.addFirst(4);
        // list.addFirst(45);
        // list.addFirst(2);
        // int index = linearSearch(list.head ,1);
        // if(index != -1){
        //     System.out.println("Element found at index " + index + ".");
        // }else{
        //     System.out.println("Element not found.");
        // }
    }

    

public static int linearSearchArr(int array[], int value){
    for(int i = 0; i<array.length; i++)
        if(array[i]==value){
            return i;
        }
        return -1;
}
}
// public static int linearSearch(Node head, int value) {
//     if(head == null){
//         return -1;
//     }
//         Node temp = head;
//         while(temp!=null){
//             if(temp.data==value){
//                 return 1;
//             }
//             temp = temp.next;
//         }
//         return -1;
//     }

// }