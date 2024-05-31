public class HashDouble {
    Entry hashT[];
   int elements;
   int prime = 3;
   Entry nonItem;
   public HashDouble(int size){
       hashT = new Entry[size];
       nonItem = new Entry(-1, 0);
   }
   int hashFunc1(int key){
       return key%=hashT.length;
   }
   int hashFunc2(int key){
       return prime - (key%prime);
   }
   void insert(Entry entry){
       if(elements<hashT.length){
           int index = hashFunc1(entry.key);
           int step = hashFunc2(entry.key);
           while(hashT[index]!=null && hashT[index].key != -1){
               if(hashT[index].key == entry.key){
                   hashT[index].val = entry.val;
                   return;
               }else{
                   index+=step;
                   index%=hashT.length;
               }
           }
       }
   }
   boolean delete(int key){
        if(elements>=0){
            int index = hashFunc1(key);
            int step = hashFunc2(key);
            while(hashT[index]!=null){
                if(hashT[index].key == key){
                    hashT[index] = nonItem;
                    elements--;
                    return true;
                }
                index+=step;
                index%=hashT.length;
            }
        }
        return false;
    }
   
    boolean find(int key){
        if(elements>=0){
            int index = hashFunc1(key);
            int step = hashFunc2(key);
            while(hashT[index]!=null){
                if(hashT[index].key == key){
                    return true;
                }
                index+=step;
                index%=hashT.length;
            }
        }
        return false;
    }
   
    public static void main(String args[]){
       HashTable ht = new HashTable(11);
       ht.insert(new Entry(5, 20));
       ht.insert(new Entry(27, 200));
       System.out.println(ht.find(27));
       System.out.println(ht.delete(5));
       System.out.println(ht.find(27));
}
}