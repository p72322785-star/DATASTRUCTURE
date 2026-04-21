class p1 {
    public static void main(String[] args) {
        String str = "hello";

        StringBuilder sb = new StringBuilder();
        sb.append(str);

        sb.reverse();

        System.out.println("Reversed: " + sb.toString());
    }
}