public class Main {
    public static void main(String[] args) {
        HashTable ht = new HashTable(17);
        ht.insert(new Entry(4, 12));
        ht.insert(new Entry(26, 30));
        ht.insert(new Entry(15, 200));
        ht.insert(new Entry(4, 12));
        ht.insert(new Entry(4, 12));
    }
}
