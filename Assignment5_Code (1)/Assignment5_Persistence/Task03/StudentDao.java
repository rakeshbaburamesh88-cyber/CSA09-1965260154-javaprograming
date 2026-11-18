import java.sql.*;
import java.util.*;

public class StudentDao implements Dao<Student, Integer> {

    Connection con;

    public StudentDao(Connection con) {
        this.con = con;
    }

    public void insert(Student s) {
        try {
            String sql =
                "INSERT INTO student VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, s.id);
            ps.setString(2, s.name);
            ps.setString(3, s.department);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Student findById(Integer id) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "SELECT * FROM student WHERE id=?"
            );

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Student> findAll() {
        List<Student> list = new ArrayList<>();

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                list.add(new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("department")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    public void update(Student s) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE student SET name=?, department=? WHERE id=?"
            );

            ps.setString(1, s.name);
            ps.setString(2, s.department);
            ps.setInt(3, s.id);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            PreparedStatement ps = con.prepareStatement(
                "DELETE FROM student WHERE id=?"
            );

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
