class p2 {
    static class Node {
        String title;
        @SuppressWarnings("unused")
                Node prev;
        Node next;
        Node(String t){ title=t; }
    }

    static Node head, tail;

    static void add(String t){
        Node n = new Node(t);
        if(head==null){ head=tail=n; return; }
        tail.next=n; n.prev=tail; tail=n;
    }

    static void display(){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.title);
            temp=temp.next;
        }
    }

    public static void main(String[] args){
        add("Movie1"); add("Movie2");
        display();
    }
}