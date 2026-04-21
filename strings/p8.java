import java.io.*;

class p8 {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

        String input;

        while (true) {
            input = br.readLine();
            if (input.equals("exit")) break;

            bw.write(input);
            bw.newLine();
        }

        bw.close();
    }
}