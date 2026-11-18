import java.sql.*;

public class DatabaseInfo {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college",
            "root",
            "password"
        );

        DatabaseMetaData md = con.getMetaData();

        System.out.println(
            "Database: " + md.getDatabaseProductName()
        );

        System.out.println(
            "Database Version: " + md.getDatabaseProductVersion()
        );

        System.out.println(
            "Driver Version: " + md.getDriverVersion()
        );

        ResultSet rs = md.getTables(
            null, null, "%", new String[]{"TABLE"}
        );

        System.out.println("Tables:");

        while (rs.next()) {
            System.out.println(rs.getString("TABLE_NAME"));
        }

        con.close();
    }
}
