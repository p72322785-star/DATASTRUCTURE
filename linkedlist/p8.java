class p8 {
    static class Node {
        String text;
        Node prev,next;
        Node(String t){ text=t; }
    }

    static Node current;

    static void add(String t){
        Node n=new Node(t);
        if(current!=null){
            current.next=n;
            n.prev=current;
        }
        current=n;
    }

    static void undo(){
        if(current.prev!=null) current=current.prev;
    }

    @SuppressWarnings("unused")
    static void redo(){
        if(current.next!=null) current=current.next;
    }

    static void show(){
        System.out.println(current.text);
    }

    public static void main(String[] args){
        add("A"); add("B"); add("C");
        undo(); show();
    }
}