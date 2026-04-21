class p5 {
    static class Node {
        int id;
        String title;
        @SuppressWarnings("unused")
                Node prev;
        Node next;
        Node(int i,String t){ id=i; title=t; }
    }

    static Node head,tail;

    static void add(int i,String t){
        Node n=new Node(i,t);
        if(head==null){ head=tail=n; return; }
        tail.next=n; n.prev=tail; tail=n;
    }

    static void display(){
        Node t=head;
        while(t!=null){
            System.out.println(t.id+" "+t.title);
            t=t.next;
        }
    }

    public static void main(String[] args){
        add(1,"Book1"); add(2,"Book2");
        display();
    }
}