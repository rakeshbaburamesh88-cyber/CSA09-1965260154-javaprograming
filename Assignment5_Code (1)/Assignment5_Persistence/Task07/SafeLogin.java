import java.sql.*;

public class SafeLogin {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college",
            "root",
            "password"
        );

        String id = "student01";
        String pwd = "wrongPassword";

        String sql =
            "SELECT * FROM users WHERE id=? AND pwd=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, id);
        ps.setString(2, pwd);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Invalid Login");
        }

        con.close();
    }
}
