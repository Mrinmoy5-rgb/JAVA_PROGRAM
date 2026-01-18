import java.sql.*;
import java.util.Scanner;

public class StudentManagementSystem {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> updateStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid choice!");
            }
        }
    }

    private static void addStudent() {

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine();

        System.out.print("Enter Course: ");
        String course = scanner.nextLine();

        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Section (e.g., CSE-B): ");
        String section = scanner.nextLine();

        String sql = "INSERT INTO students (name, email, course, roll_no, section) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection()) {

            if (conn == null) {
                System.out.println("❌ Database connection failed!");
                return;
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, email);
                pstmt.setString(3, course);
                pstmt.setInt(4, rollNo);
                pstmt.setString(5, section);

                pstmt.executeUpdate();
                System.out.println("✅ Student registered successfully!");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void viewStudents() {

        String sql = "SELECT * FROM students";

        try (Connection conn = DBConnection.getConnection()) {

            if (conn == null) {
                System.out.println("❌ Database connection failed!");
                return;
            }

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                System.out.println("\nID | Name | Email | Course | Roll No | Section");
                System.out.println("-----------------------------------------------------------");

                while (rs.next()) {
                    System.out.printf("%d | %s | %s | %s | %d | %s%n",
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("course"),
                            rs.getInt("roll_no"),
                            rs.getString("section"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateStudent() {

        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter New Section: ");
        String newSection = scanner.nextLine();

        String sql = "UPDATE students SET section = ? WHERE id = ?";

        try (Connection conn = DBConnection.getConnection()) {

            if (conn == null) {
                System.out.println("❌ Database connection failed!");
                return;
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, newSection);
                pstmt.setInt(2, id);

                int rows = pstmt.executeUpdate();
                if (rows > 0)
                    System.out.println("✅ Section updated successfully!");
                else
                    System.out.println("❌ Student ID not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void deleteStudent() {

        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = DBConnection.getConnection()) {

            if (conn == null) {
                System.out.println("❌ Database connection failed!");
                return;
            }

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, id);
                int rows = pstmt.executeUpdate();

                if (rows > 0)
                    System.out.println("✅ Student deleted successfully!");
                else
                    System.out.println("❌ Student ID not found.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
