import java.io.*;

public class SalesReport {
    public static void main(String[] args) {
        try (
            BufferedReader br =
                new BufferedReader(new FileReader("sales.txt"));
            PrintWriter pw =
                new PrintWriter("report.txt")
        ) {
            String line;

            while ((line = br.readLine()) != null) {
                pw.println(line);
            }

            System.out.println("Report generated");
        }
        catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
