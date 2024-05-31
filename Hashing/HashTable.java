public class HashTable{
    Entry hashT[];
    int elements;
    public HashTable(int size){
        hashT = new Entry[size];
    }
    int hashFunc(int key){
        return key%=hashT.length;
    }
    void insert(Entry entry){
        if(elements<hashT.length){
            int index = hashFunc(entry.key);
            while(hashT[index] != null && hashT[index].key != -1){
                if(hashT[index].key == entry.key){
                    hashT[index].val = entry.val;
                    return;
                }
                index++;
                index%=hashT.length;
            }
            hashT[index] = entry;
            elements++;
            System.out.println("the item hass been added at "+ index);
        }
    }
    boolean delete(int key){
        if(elements>=0){
            int index = hashFunc(key);
            while(hashT[index]!=null){
                if(hashT[index].key == key){
                    hashT[index] = new Entry(-1, 0);
                    elements--;
                    return true;
                }
                index++;
                index%=hashT.length;
            }
        }
        return false;
    }
     int find(int key){
        if(elements>=0){
            int index = hashFunc(key);
            while(hashT[index]!=null){
                if(hashT[index].key == key){
                    return index;
                }
                index++;
                index%=hashT.length;
            }
        }
        return -1;
    }
    void display(){
        for(int i=0; i<hashT.length; i++){
            if(hashT[i] != null)
                System.out.print(hashT[i].key +"-->"+hashT[i].val+ " ");
            else
                System.out.print(" * ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        HashTable ht = new HashTable(11);
        ht.insert(new Entry(4, 15));
        ht.insert(new Entry(15, 200));
        ht.insert(new Entry(21, 51));
        ht.insert(new Entry(10, 21));
        
        int index = ht.find(15);
        if(index>-1)
            System.out.println("The element is at index "+ index);
        else
            System.out.println("The elements is not present..");
        
        boolean deleted = ht.delete(4);
        if(deleted)
            System.out.println("The element has been deleted ...");
        else
            System.out.println("The element couldnt be found..");
        
        index = ht.find(15);
        if(index>-1)
            System.out.println("The element is at index "+ index);
        else
            System.out.println("The elements is not present..");
        
        ht.insert(new Entry(26, 300));
        
        ht.display();
    }
}