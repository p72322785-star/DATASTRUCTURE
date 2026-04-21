class p7 {
    static class Node {
        int id;
        Node next;
        Node(int i){ id=i; }
    }

    static Node head;

    static void add(int id){
        Node n=new Node(id);
        n.next=head;
        head=n;
    }

    static void display(){
        Node t=head;
        while(t!=null){
            System.out.print(t.id+" ");
            t=t.next;
        }
    }

    public static void main(String[] args){
        add(1); add(2); add(3);
        display();
    }
}