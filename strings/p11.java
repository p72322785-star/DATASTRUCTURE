class p11 {
    public static void main(String[] args) {

        String[] sentences = {
            "Java is powerful",
            "Data structures are important",
            "Practice coding daily"
        };

        String target = "coding";
        String result = "Not Found";

        for (String s : sentences) {
            if (s.contains(target)) {
                result = s;
                break;
            }
        }

        System.out.println(result);
    }
}