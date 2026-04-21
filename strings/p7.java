import java.io.*;

class p7 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws Exception {

        InputStreamReader isr = new InputStreamReader(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }
}