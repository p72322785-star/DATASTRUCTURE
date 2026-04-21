class p3 {
    static class Node {
        int id;
        Node next;
        Node(int id){ this.id=id; }
    }

    static Node head;

    static void add(int id){
        Node n=new Node(id);
        if(head==null){
            head=n; head.next=head; return;
        }
        Node temp=head;
        while(temp.next!=head) temp=temp.next;
        temp.next=n;
        n.next=head;
    }

    static void display(){
        if(head==null) return;
        Node temp=head;
        do{
            System.out.print(temp.id+" ");
            temp=temp.next;
        }while(temp!=head);
    }

    public static void main(String[] args){
        add(1); add(2); add(3);
        display();
    }
}