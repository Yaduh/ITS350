import java.util.LinkedList;

public class SeperateChaning{
        LinkedList <Entry> hashT[];
        public SeperateChaning(int size){
            hashT = new LinkedList[size];
        }
        int hashF(int key){
            return key%hashT.length;
        }
        public void insert(Entry entry){
            int index = hashF(entry.key);
            if(hashT[index]==null)
                hashT[index] = new LinkedList();
            for(Entry e:hashT[index]){
                if(e.key == entry.key){
                    e.val = entry.val;
                    return;
                }
            }
            hashT[index].addLast(entry);
        }
        
        void delete(int key){
            Entry entry = getEntry(key);
            if(entry != null){
                getList(key).remove(entry);
            }else{
                
            }
        }
        void display(){
            for(int i=0; i<hashT.length; i++){
                if(hashT[i] != null){
                    for(Entry e:hashT[i]){
                        System.out.print(e.key +"-->"+ e.val +" ");
                    }
                    System.out.println();
                }else
                    System.out.println("*");
            }
        }
        Entry getEntry(int key){
            LinkedList<Entry> list = getList(key);
            if(list!=null){
                for(Entry e:list){
                    if(e.key == key){
                        return e;
                    }
                }
            }
            return null;
        }
        LinkedList<Entry> getList(int key){
            int index = hashF(key);
            return hashT[index];
        }
        public static void main(String args[]){
            SeperateChaning ht = new SeperateChaning(5);
            ht.insert(new Entry(0,15));
            ht.insert(new Entry(10, 11));
            ht.insert(new Entry(13, 19));
            ht.display();
            ht.delete(10);
            ht.display();
        }    
    }
