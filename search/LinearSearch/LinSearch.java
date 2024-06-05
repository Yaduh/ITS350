package search.LinearSearch;
import Lists.*;
public class LinSearch{

    static int linearSearch(int array[], int key){
        if(array.length==0){
            System.out.println("Empty");
        }else{
            for(int i=0; i<array.length; i++){
                if(array[i]==key)
                    return i;
            }
        }
        return -1;
    }
    static int linearSearch(Node head, int key){
        if(head==null)
            return -1;
        Node temp = head;
        while(temp!=null){
            if(temp.data==key)
                return 1;
            temp = temp.next;
        }
        return -1;
    }
    public static void main(String args[]){
        SLList list = new SLList();
        list.addFirst(34);
        list.addFirst(2);
        list.addFirst(12);
        int result = linearSearch(list.head, 12);
        if(result<0)
            System.out.println("The element is not present");
        else
            System.out.println("The element is present");
        
        int array[] = {3, 1, 5, 9};
        int index = linearSearch(array, 9);
        if(index<0)
            System.out.println("the element is not present");
        else
            System.out.println("the element is present at index "+index);
    }
}