/*
    HashTable
    using Linear Probing
*/

package DS;

public class HashTable_LinearProbing {
    // class for storing (key, value)
    class Node {
        String key, value;

        // constructor
        Node(String key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    // buckets
    int N = 8; // bucket size
    Node[] buckets = new Node[N];
    int size = 0;

    // put (key, value)
    public void put(String key, String value) {
        if (size == N)
            return; // full

        int h = key.hashCode(); // hashing
        h = Math.abs(h) % N; // compressor

        int i = h;
        while (i != h - 1) {
            if (buckets[i] == null) {
                buckets[i] = new Node(key, value);
                break;
            }

            i++;
            if (i == N) {
                i = 0;
            }
        }
        size++;
    }

    public String find(String key) {
        int h = key.hashCode(); // hashing
        h = Math.abs(h) % N; // compressor

        int i = h;
        while (i != h - 1) {
            if (buckets[i] != null && buckets[i].key.equals(key)) {
                return buckets[i].value;
            }

            i++;
            if (i == N) {
                i = 0;
            }
        }
        return null;
    }

    public void erase(String key) {
        int h = key.hashCode(); // hashing
        h = Math.abs(h) % N; // compressor

        int i = h;
        while (i != h - 1) {
            if (buckets[i] != null && buckets[i].key.equals(key)) {
                buckets[i] = null;
                break;
            }

            i++;
            if (i == N) {
                i = 0;
            }
        }
        size--;
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public void describe() {
        for (int i = 0; i < N; i++) {
            System.out.print(i);
            if (buckets[i] == null) {
                System.out.println();
                continue;
            }

            System.out.print(" (");
            System.out.print(buckets[i].key);
            System.out.print(",");
            System.out.print(buckets[i].value);
            System.out.println(")");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashTable_LinearProbing table = new HashTable_LinearProbing();

        table.put("1", "o");
        table.put("2", "t");
        table.put("5", "f");
        table.describe(); // _ 1 2 _ _ 5 _ _

        table.put("9", "n");
        table.describe(); // _ 1 2 9 _ 5 _ _

        System.out.println(table.find("5"));
        System.out.println(table.find("9"));

        table.erase("2");
        table.erase("9");
        table.describe(); // _ 1 _ _ _ 5 _ _
    }
}
