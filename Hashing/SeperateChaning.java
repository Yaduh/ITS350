import java.util.LinkedList;
import java.util.Map.Entry;

public class SeperateChaning{
    LinkedList<Entry>[] hashT;
    public SeperateChaning(int size){
        hashT = new LinkedList[size];
    }    

    public int hashFunction(){
        return key%hashT.length;
    }

    public void insert(Entry<K,V> entry){
        int index = hashFunction(entry.key);
        
        if(hashT[index]==null){

        hashT[index] = new LinkedList<>();
            for(Entry e : hashT[index]){
                if(e.key == entry.key){
                    e.val = entry.val;
                    return;
                }
            }
        }
    }   
        
    public static void main(String... args) {
        
    }
}