import java.nio.file.*;
import java.io.IOException;
import java.util.List;

public class ReadAllLines {
    public static void main(String[] args) throws IOException {

        List<String> lines =
            Files.readAllLines(Path.of("attendance.txt"));

        System.out.println("Total Lines: " + lines.size());
    }
}
