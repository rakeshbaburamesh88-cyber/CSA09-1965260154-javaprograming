import java.sql.*;

public class LoginCheck {

    public static void main(String[] args) throws Exception {

        Connection con = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/college",
            "root",
            "password"
        );

        String sql =
            "SELECT * FROM users WHERE id=? AND pwd=?";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, "student01");
        ps.setString(2, "enteredPassword");

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Invalid Login");
        }

        con.close();
    }
}
