Student Management System (Java + MySQL)

    A simple Student Management System built using Java Swing, MySQL, and JDBC.
    The project allows managing student records such as Name, Email, Course, Roll Number, and Section through a graphical user interface.

🏷️ Technologies & Tools

    Java (Core Java, JDK 22+)

    Java Swing (GUI)

    MySQL Database

    JDBC (MySQL Connector/J)

    IntelliJ IDEA

✨ Features

    Add new students

    View all student records in a table

    Update student details (e.g., section)

    Delete student records

    Store data in MySQL database using JDBC

    Simple and user-friendly GUI

📌 Database Details

    Database name: student_db

    Table: students

    Table Columns:

    id

    name

    email

    course

    roll_no

    section

▶️ How to Run the Project

    Install Java JDK

    Install MySQL Server / MySQL Workbench

    Open the project in IntelliJ IDEA

    Create the database and table in MySQL

    Download MySQL Connector/J

    Add the JAR file to IntelliJ project libraries

    Update database credentials in DBConnection.java:

    URL: jdbc:mysql://localhost:3306/student_db

    Username: your MySQL username

    Password: your MySQL password

    Run StudentManagementGUI.java

📂 Project Files
    ManagementProject/
    ├── DBConnection.java
    ├── StudentManagementGUI.java
    └── StudentManagementSystem.java

👨‍💻 Author

    Mrinmoy Debnath
    