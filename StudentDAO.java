import java.sql.*;
import java.util.*;


public class StudentDAO {
    public List<Student> getAll() {
        List<Student> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
            while (rs.next()) {
                Student s = new Student(
                        rs.getString("name"), rs.getString("roll_no"), rs.getString("department"),
                        rs.getString("email"), rs.getString("phone"), rs.getInt("marks")
                );
                s.setId(rs.getInt("id"));
                list.add(s);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }


    public void insert(Student s) { /* SQL INSERT logic */ }
    public void update(String rollNo, Student s) { /* SQL UPDATE logic */ }
    public void delete(String rollNo) { /* SQL DELETE logic */ }
    public Student findByRollNo(String rollNo) { return null; }
}
