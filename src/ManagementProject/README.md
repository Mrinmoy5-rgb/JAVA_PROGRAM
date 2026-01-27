
# 🎓 Student Management System (Java + MySQL)

![Java](https://img.shields.io/badge/Java-JDK%2022+-orange?style=for-the-badge&logo=java)
![Swing](https://img.shields.io/badge/Java%20Swing-GUI-green?style=for-the-badge)
![JDBC](https://img.shields.io/badge/JDBC-Database%20Connectivity-blue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-purple?style=for-the-badge&logo=intellijidea)

A simple Student Management System built using **Java Swing**, **MySQL**, and **JDBC**.  
The project allows managing student records such as **Name, Email, Course, Roll Number, and Section** through a graphical user interface.

---

## 🏷️ Technologies & Tools
```
- Java (Core Java, JDK 22+)
- Java Swing (GUI)
- MySQL Database
- JDBC (MySQL Connector/J)
- IntelliJ IDEA
```
---

## ✨ Features
```
- Add new students  
- View all student records in a table  
- Update student details (e.g., section)  
- Delete student records  
- Store data in MySQL database using JDBC  
- Simple and user-friendly GUI  
```
---

## 📌 Database Details

- **Database name:** `student_db`  
- **Table:** `students`  
- **Table Columns:**  
  `id | name | email | course | roll_no | section`

---

## ▶️ How to Run the Project
```
1. Install Java JDK  
2. Install MySQL Server / MySQL Workbench  
3. Open the project in IntelliJ IDEA  
4. Create the database and table in MySQL  
5. Download MySQL Connector/J  
6. Add the JAR file to IntelliJ project libraries  
7. Update database credentials in `DBConnection.java`:
   - URL: `jdbc:mysql://localhost:3306/student_db`
   - Username: your MySQL username
   - Password: your MySQL password  
8. Run `StudentManagementGUI.java`

```
---
## 📂 Project Files

```

ManagementProject/
├── Databases/
├── DBConnection.java
├── StudentManagementGUI.java
└── StudentManagementSystem.java
```


---

## 👨‍💻 Author

**Mrinmoy Debnath**

