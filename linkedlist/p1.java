class p1 {
    static class Node {
        int roll ;
        String name;
        char grade;
        Node next;

        Node(int r, String n, char g) {
            roll = r; name = n; grade = g;
        }
    }

    static Node head;

    static void addLast(int r, String n, char g) {
        Node newNode = new Node(r,n,g);
        if (head == null) { head = newNode; return; }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
    }

    static void display() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.roll+" "+temp.name+" "+temp.grade);
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        addLast(1,"A",'A');
        addLast(2,"B",'B');
        display();
    }
}