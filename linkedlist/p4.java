class p4 {
    static class Node {
        @SuppressWarnings("unused")
                int id;
        int qty;
        double price;
        Node next;
        Node(int i,int q,double p){ id=i; qty=q; price=p; }
    }

    static Node head;

    static void add(int i,int q,double p){
        Node n=new Node(i,q,p);
        n.next=head;
        head=n;
    }

    static double total(){
        double sum=0;
        Node t=head;
        while(t!=null){
            sum+=t.qty*t.price;
            t=t.next;
        }
        return sum;
    }

    public static void main(String[] args){
        add(1,10,5);
        add(2,2,20);
        System.out.println("Total="+total());
    }
}