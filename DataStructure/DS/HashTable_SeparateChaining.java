/*
    HashTable
    using Separate Chaining
*/

package DS;

public class HashTable_SeparateChaining {
    // Node Class for (Key-Value) Chain
    class Node {
        Node next;
        String key, value;

        // constructor
        Node(String key, String value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // buckets
    int N = 8; // bucket size
    Node[] buckets = new Node[N];
    int size = 0;

    // put (key, value)
    public void put(String key, String value) {
        int h = key.hashCode(); // hashing
        h = Math.abs(h) % N; // compressor
        buckets[h] = new Node(key, value, buckets[h]);
        size++;
    }

    public String find(String key) {
        int h = key.hashCode(); // hashing
        h = Math.abs(h) % N; // compressor

        for (Node n = buckets[h]; n != null; n = n.next) {
            if (n.key.equals(key))
                return n.value;
        }
        return null;
    }

    public void erase(String key) {
        int h = key.hashCode(); // hashing
        h = Math.abs(h) % N; // compressor

        for (Node prev = null, n = buckets[h]; n != null; prev = n, n = n.next) {
            if (n.key.equals(key)) {
                if (prev == null) {
                    buckets[h] = n.next;
                } else {
                    prev.next = n.next;
                }
                size--;
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    // describle; only for checking
    public void describe() {
        for (Node n : buckets) {
            while (n != null) {
                System.out.print("(");
                System.out.print(n.key);
                System.out.print(",");
                System.out.print(n.value);
                System.out.print(") ");

                n = n.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        HashTable_SeparateChaining table = new HashTable_SeparateChaining();

        table.put("one", "1");
        table.put("two", "2");
        table.put("three", "3");
        table.put("four", "4");
        table.put("five", "5");
        table.put("six", "6");
        table.put("seven", "7");
        table.put("eight", "8");
        table.put("nine", "9");
        table.put("ten", "10");
        table.put("eleven", "11");
        table.put("twelve", "12");
        table.put("thirteen", "13");
        table.put("fourteen", "14");
        table.put("fifteen", "15");
        table.put("sixteen", "16");

        table.describe();

        // find
        System.out.println(table.find("four"));
        System.out.println(table.find("twelve"));

        table.describe();

        // delete
        table.erase("twelve");
        table.erase("sixteen");

        table.describe();
    }
}
