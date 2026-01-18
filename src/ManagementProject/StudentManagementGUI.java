package ManagementProject;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.sql.*;

public class StudentManagementGUI extends JFrame {

    private JTextField txtId, txtName, txtEmail, txtCourse, txtRoll, txtSection;
    private JTable table;
    private DefaultTableModel model;

    public StudentManagementGUI() {
        setTitle("Student Management System");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLookAndFeel();
        initUI();
        loadStudents();
    }

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception ignored) {}
    }

    private void initUI() {

        // 🌈 Gradient Background
        JPanel background = new GradientPanel();
        background.setLayout(new BorderLayout(20, 20));
        background.setBorder(new EmptyBorder(20, 20, 20, 20));
        setContentPane(background);

        // 🧾 FORM PANEL
        JPanel formPanel = createCardPanel(new GridLayout(2, 6, 15, 10));

        txtId = new JTextField();
        txtName = new JTextField();
        txtEmail = new JTextField();
        txtCourse = new JTextField();
        txtRoll = new JTextField();
        txtSection = new JTextField();

        formPanel.add(new JLabel("ID (for update/delete)"));
        formPanel.add(new JLabel("Name"));
        formPanel.add(new JLabel("Email"));
        formPanel.add(new JLabel("Course"));
        formPanel.add(new JLabel("Roll No"));
        formPanel.add(new JLabel("Section"));

        formPanel.add(txtId);
        formPanel.add(txtName);
        formPanel.add(txtEmail);
        formPanel.add(txtCourse);
        formPanel.add(txtRoll);
        formPanel.add(txtSection);

        // 📊 TABLE PANEL
        JPanel tablePanel = createCardPanel(new BorderLayout());

        model = new DefaultTableModel(
                new String[]{"ID", "Name", "Email", "Course", "Roll No", "Section"}, 0
        );
        table = new JTable(model);
        styleTable(table);

        tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);

        // 🔘 BUTTON PANEL
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.setOpaque(false);

        JButton btnAdd = createButton("➕ Add");
        JButton btnUpdate = createButton("✏ Update");
        JButton btnDelete = createButton("🗑 Delete");
        JButton btnRefresh = createButton("🔄 Refresh");

        btnAdd.addActionListener(e -> addStudent());
        btnUpdate.addActionListener(e -> updateStudent());
        btnDelete.addActionListener(e -> deleteStudent());
        btnRefresh.addActionListener(e -> loadStudents());

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnUpdate);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnRefresh);

        background.add(formPanel, BorderLayout.NORTH);
        background.add(tablePanel, BorderLayout.CENTER);
        background.add(buttonPanel, BorderLayout.SOUTH);
    }

    // 🎨 UI HELPERS

    private JPanel createCardPanel(LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220)),
                new EmptyBorder(15, 15, 15, 15)
        ));
        return panel;
    }

    private JButton createButton(String text) {
        JButton btn = new JButton(text);
        btn.setFocusPainted(false);
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBorder(new EmptyBorder(8, 18, 8, 18));
        return btn;
    }

    private void styleTable(JTable table) {
        table.setRowHeight(28);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        table.setGridColor(new Color(230, 230, 230));

        JTableHeader header = table.getTableHeader();
        header.setBackground(new Color(70, 130, 180));
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
    }

    // 🌈 Gradient Panel
    static class GradientPanel extends JPanel {
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(new GradientPaint(
                    0, 0, new Color(230, 240, 255),
                    0, getHeight(), new Color(200, 220, 245)
            ));
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    // 🧠 DATABASE METHODS

    private void addStudent() {
        try {
            String sql = "INSERT INTO students (name,email,course,roll_no,section) VALUES (?,?,?,?,?)";
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, txtName.getText());
            ps.setString(2, txtEmail.getText());
            ps.setString(3, txtCourse.getText());
            ps.setInt(4, Integer.parseInt(txtRoll.getText()));
            ps.setString(5, txtSection.getText());

            ps.executeUpdate();
            loadStudents();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error adding student");
        }
    }

    private void loadStudents() {
        model.setRowCount(0);
        try {
            Connection conn = DBConnection.getConnection();
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM students");
            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("course"),
                        rs.getInt("roll_no"),
                        rs.getString("section")
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading data");
        }
    }

    private void updateStudent() {
        try {
            String sql = "UPDATE students SET section=? WHERE id=?";
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtSection.getText());
            ps.setInt(2, Integer.parseInt(txtId.getText()));
            ps.executeUpdate();
            loadStudents();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error updating student");
        }
    }

    private void deleteStudent() {
        try {
            String sql = "DELETE FROM students WHERE id=?";
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(txtId.getText()));
            ps.executeUpdate();
            loadStudents();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error deleting student");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentManagementGUI().setVisible(true));
    }
}
