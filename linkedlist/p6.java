class p6 {
    static class Node {
        int id, burst;
        Node next;
        Node(int i,int b){ id=i; burst=b; }
    }

    static Node head;

    static void add(int i,int b){
        Node n=new Node(i,b);
        if(head==null){ head=n; head.next=head; return; }
        Node t=head;
        while(t.next!=head) t=t.next;
        t.next=n; n.next=head;
    }

    static void run(int q){
        Node t=head;
        do{
            if(t.burst>0){
                int exec=Math.min(q,t.burst);
                t.burst-=exec;
                System.out.println("P"+t.id+" "+exec);
            }
            t=t.next;
        }while(t!=head);
    }

    public static void main(String[] args){
        add(1,5); add(2,3);
        run(2);
    }
}