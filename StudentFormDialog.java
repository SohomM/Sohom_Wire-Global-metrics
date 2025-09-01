import javax.swing.*;
import java.awt.*;


public class StudentFormDialog extends JDialog {
    private final AdminService service;
    private final Student student;


    public StudentFormDialog(Frame parent, AdminService service, Student student) {
        super(parent, true);
        this.service = service;
        this.student = student;


        setTitle(student == null ? "Add Student" : "Edit Student");
        setSize(400, 300);
        setLocationRelativeTo(parent);


        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));
        JTextField nameField = new JTextField(student != null ? student.getName() : "");
        JTextField rollField = new JTextField(student != null ? student.getRollNo() : "");
        JTextField deptField = new JTextField(student != null ? student.getDepartment() : "");
        JTextField emailField = new JTextField(student != null ? student.getEmail() : "");
        JTextField phoneField = new JTextField(student != null ? student.getPhone() : "");
        JTextField marksField = new JTextField(student != null ? String.valueOf(student.getMarks()) : "");


        panel.add(new JLabel("Name:")); panel.add(nameField);
        panel.add(new JLabel("Roll No:")); panel.add(rollField);
        panel.add(new JLabel("Department:")); panel.add(deptField);
        panel.add(new JLabel("Email:")); panel.add(emailField);
        panel.add(new JLabel("Phone:")); panel.add(phoneField);
        panel.add(new JLabel("Marks:")); panel.add(marksField);


        JButton saveBtn = new JButton("Save");
        saveBtn.addActionListener(e -> {
            try {
                if (student == null) {
                    Student s = new Student(nameField.getText(), rollField.getText(), deptField.getText(),
                            emailField.getText(), phoneField.getText(), Integer.parseInt(marksField.getText()));
                    service.addStudent(s);
                } else {
                    student.setName(nameField.getText());
                    student.setDepartment(deptField.getText());
                    student.setEmail(emailField.getText());
                    student.setPhone(phoneField.getText());
                    student.setMarks(Integer.parseInt(marksField.getText()));
                    service.updateStudentByRollNo(student.getRollNo(), student);
                }
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error saving student: " + ex.getMessage());
            }
        });


        panel.add(new JLabel()); panel.add(saveBtn);
        add(panel);
    }
}