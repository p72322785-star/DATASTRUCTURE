class p9 {

    static class Node {
        int key, value;
        Node next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final Node[] bucket = new Node[1000];

    private int hash(int key) {
        return key % bucket.length;
    }

    public void put(int key, int value) {
        int i = hash(key);
        Node head = bucket[i];

        for (Node curr = head; curr != null; curr = curr.next) {
            if (curr.key == key) {
                curr.value = value;
                return;
            }
        }

        Node newNode = new Node(key, value);
        newNode.next = head;
        bucket[i] = newNode;
    }

    public int get(int key) {
        int i = hash(key);
        Node curr = bucket[i];

        while (curr != null) {
            if (curr.key == key)
                return curr.value;
            curr = curr.next;
        }
        return -1;
    }

    public void remove(int key) {
        int i = hash(key);
        Node curr = bucket[i], prev = null;

        while (curr != null) {
            if (curr.key == key) {
                if (prev == null)
                    bucket[i] = curr.next;
                else
                    prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }
}