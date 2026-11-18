import java.io.*;
import java.sql.*;
import java.util.*;

public class PassMigration {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/college";
        String user = "root";
        String password = "password";

        List<String[]> validRecords = new ArrayList<>();
        List<String> failedRecords = new ArrayList<>();

        try (BufferedReader br =
                new BufferedReader(new FileReader("passes.csv"))) {

            String line;

            while ((line = br.readLine()) != null) {

                String[] p = line.split(",", -1);

                try {

                    if (p.length != 5) {
                        throw new IllegalArgumentException();
                    }

                    Integer.parseInt(p[3]);
                    Double.parseDouble(p[4]);

                    validRecords.add(p);

                } catch (Exception e) {
                    failedRecords.add(line);
                }
            }
        }

        try (Connection con =
                DriverManager.getConnection(url, user, password)) {

            int loaded = PassLoader.loadAll(con, validRecords);

            System.out.println("Records Loaded: " + loaded);
        }

        System.out.println("Failed Records:");

        for (String record : failedRecords) {
            System.out.println(record);
        }
    }
}
