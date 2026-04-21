class p3 {
    public static void main(String[] args) {
        String[] arr = {"Hello", " ", "World", "!"};

        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer sb = new StringBuffer();

        for (String s : arr) {
            sb.append(s);
        }

        System.out.println(sb.toString());
    }
}