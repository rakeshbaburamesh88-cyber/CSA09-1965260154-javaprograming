import java.io.*;

public class BufferedLineCounter {
    public static void main(String[] args) throws IOException {

        String file = "attendance.txt";
        long lines = 0;

        try (BufferedReader br = new BufferedReader(
                new FileReader(file))) {

            while (br.readLine() != null) {
                lines++;
            }
        }

        System.out.println("Total Lines: " + lines);
    }
}
