import java.io.*;

class p6 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String target = "hello";
        int count = 0;

        String line;
        while ((line = br.readLine()) != null) {
            String[] words = line.split("\\s+");

            for (var w : words) {
                if (w.equals(target)) count++;
            }
        }

        System.out.println("Count: " + count);
        br.close();
    }
}