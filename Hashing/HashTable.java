public class HashTable{
    Entry [] hashTable;
    int elements;

    public HashTable(int size){
        hashTable = new Entry[size];
    }

    void insert(Entry entry){
        if(elements<hashTable.length){
            int index = hashFunc(entry.key);
            while(hashTable[index]!=null && hashTable[index].key != -1){// if index is taken
                index ++; //increment by 1
                index %= hashTable.length;
            }
            hashTable[index] = entry;
            elements++;
        }
    }

    boolean delete(int key){
        int index = hashFunc(key);
        while (hashTable[index]!=null) {
            if(hashTable[index].key == key){
                hashTable[index] = new Entry(-1, 0);
                elements--;
                return true;
            }else{
                index++;
                index%=hashTable.length;
            }
        }
        return false;
    }

    int hashFunc(int key){
        return key%=hashTable.length;
    }

    boolean find(int key){
        int index = hashFunc(key);
        while (hashTable[index]!=null) {
            if(hashTable[index].key == key){
                return true;
            }else{
                index++;
                index%=hashTable.length;
            }
        }
        return false;
    }
}
