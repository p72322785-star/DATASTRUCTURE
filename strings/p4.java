class p4 {
    public static void main(String[] args) {

        int n = 100000;

        long start = System.nanoTime();
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < n; i++) sb1.append("hello");
        long end = System.nanoTime();
        System.out.println("StringBuilder time: " + (end - start));

        start = System.nanoTime();
        @SuppressWarnings("StringBufferMayBeStringBuilder")
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < n; i++) sb2.append("hello");
        end = System.nanoTime();
        System.out.println("StringBuffer time: " + (end - start));
    }
}