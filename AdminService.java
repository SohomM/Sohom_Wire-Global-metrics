import java.util.List;

public class AdminService {
    private final StudentDAO dao = new StudentDAO();

    public boolean login(String user, String pass) {
        return "admin".equals(user) && "admin123".equals(pass);
    }

    public List<Student> getAll() { return dao.getAll(); }
    public void addStudent(Student s) { dao.insert(s); }
    public void updateStudentByRollNo(String rollNo, Student s) { dao.update(rollNo, s); }
    public void deleteByRollNo(String rollNo) { dao.delete(rollNo); }
    public Student findByRollNo(String rollNo) { return dao.findByRollNo(rollNo); }
}