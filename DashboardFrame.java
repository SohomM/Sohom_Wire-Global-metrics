import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;


public class DashboardFrame extends JFrame {
    private final AdminService service;
    private final DefaultTableModel model;
    private final JTable table;


    public DashboardFrame(AdminService service) {
        this.service = service;
        setTitle("SmartStudent Dashboard");
        setSize(800, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        String[] columns = {"ID", "Name", "Roll No", "Department", "Email", "Phone", "Marks"};
        model = new DefaultTableModel(columns, 0);
        table = new JTable(model);
        refreshTable();


        JButton addBtn = new JButton("Add");
        JButton editBtn = new JButton("Edit");
        JButton deleteBtn = new JButton("Delete");
        JButton refreshBtn = new JButton("Refresh");


        addBtn.addActionListener(e -> openStudentForm(null));
        editBtn.addActionListener(e -> editSelected());
        deleteBtn.addActionListener(e -> deleteSelected());
        refreshBtn.addActionListener(e -> refreshTable());


        JPanel btnPanel = new JPanel();
        btnPanel.add(addBtn); btnPanel.add(editBtn); btnPanel.add(deleteBtn); btnPanel.add(refreshBtn);


        add(new JScrollPane(table), BorderLayout.CENTER);
        add(btnPanel, BorderLayout.SOUTH);
    }


    private void refreshTable() {
        model.setRowCount(0);
        List<Student> students = service.getAll();
        for (Student s : students) {
            model.addRow(new Object[]{s.getId(), s.getName(), s.getRollNo(), s.getDepartment(), s.getEmail(), s.getPhone(), s.getMarks()});
        }
    }


    private void openStudentForm(Student student) {
        StudentFormDialog dialog = new StudentFormDialog(this, service, student);
        dialog.setVisible(true);
        refreshTable();
    }


    private void editSelected() {
        int row = table.getSelectedRow();
        if (row == -1) return;
        String rollNo = table.getValueAt(row, 2).toString();
        Student student = service.findByRollNo(rollNo);
        if (student != null) openStudentForm(student);
    }


    private void deleteSelected() {
        int row = table.getSelectedRow();
        if (row == -1) return;
        String rollNo = table.getValueAt(row, 2).toString();
        int confirm = JOptionPane.showConfirmDialog(this, "Delete this student?", "Confirm", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            service.deleteByRollNo(rollNo);
            refreshTable();
        }
    }
}