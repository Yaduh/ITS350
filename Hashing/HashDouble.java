public class HashDouble {
    Entry[] ht;
    int elements;
    int prime = 3;
    public HashDouble(int size){
        ht = new Entry[size];
    }

    int hashFunc1(int key){
        return key%=ht.length;
    }
    int hashFunc2(int key){
        return prime - (key%ht.length);
    }

    void insert(Entry entry){
        if(elements<ht.length){
            int index = hashFunc1(entry.key);
            int step = hashFunc2(entry.key);
            while(ht[index]!=null && ht[index].key != -1){// if index is taken
                index += step; //increment by 1
                index %= ht.length;
            }
            ht[index] = entry;
            elements++;
        }
    } 
}