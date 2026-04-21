class p9 {
    static class Node {
        @SuppressWarnings("unused")
        int id;
        Node next;
        Node(int i){ id=i; }
    }

    static Node head;

    static void add(int id){
        Node n=new Node(id);
        if(head==null){
            head=n; head.next=head; return;
        }
        Node t=head;
        while(t.next!=head) t=t.next;
        t.next=n; n.next=head;
    }

    static void count(){
        if(head==null) return;
        int c=0;
        Node t=head;
        do{
            c++;
            t=t.next;
        }while(t!=head);
        System.out.println("Total="+c);
    }

    public static void main(String[] args){
        add(1); add(2); add(3);
        count();
    }
}