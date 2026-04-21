class p1 {

    static double calculateAverage(int[] temp) {
        if (temp.length == 0) {
            throw new IllegalArgumentException("No data available");
        }

        int total = 0;

        for (int i = 0; i < temp.length; i++) {
            total += temp[i];
        }

        return (double) total / temp.length;
    }

    public static void main(String[] args) {

        int[] temperatures = {20, 25, 22, 24, 21};

        double avg = calculateAverage(temperatures);

        System.out.println("Average Temperature: " + avg);
    }
}