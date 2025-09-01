public class Student {
    private int id;
    private String name;
    private String rollNo;
    private String department;
    private String email;
    private String phone;
    private int marks;


    // Constructor, getters, setters
    public Student(String name, String rollNo, String department, String email, String phone, int marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.department = department;
        this.email = email;
        this.phone = phone;
        this.marks = marks;
    }
}
