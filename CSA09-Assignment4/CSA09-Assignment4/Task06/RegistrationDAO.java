import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDAO {
    private final String URL = "jdbc:mysql://localhost:3306/campus_event";
    private final String USER = "root";
    private final String PASSWORD = "password"; // change to your MySQL password

    public void register(String id, String name, int eventId) throws SQLException {
        String sql = "INSERT INTO registrations "
                + "(student_id, student_name, event_id) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, eventId);
            ps.executeUpdate();
        }
    }

    // Reads rows into a list and closes all resources before returning
    public List<String[]> getRegistrations(int eventId) throws SQLException {
        String sql = "SELECT registration_id, student_id, student_name, event_id "
                + "FROM registrations WHERE event_id = ?";
        List<String[]> rows = new ArrayList<>();
        try (Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, eventId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    rows.add(new String[]{
                        String.valueOf(rs.getInt("registration_id")),
                        rs.getString("student_id"),
                        rs.getString("student_name"),
                        String.valueOf(rs.getInt("event_id"))
                    });
                }
            }
        }
        return rows;
    }
}
