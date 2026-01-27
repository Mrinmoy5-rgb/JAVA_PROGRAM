
# 🏦 Banking System – Java | JDBC | MySQL

![Java](https://img.shields.io/badge/Java-JDK%2017%2F22+-orange?style=for-the-badge&logo=java)
![JDBC](https://img.shields.io/badge/JDBC-Database%20Connectivity-blue?style=for-the-badge)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![IntelliJ IDEA](https://img.shields.io/badge/IDE-IntelliJ%20IDEA-purple?style=for-the-badge&logo=intellijidea)
![Git](https://img.shields.io/badge/Version%20Control-Git%20%26%20GitHub-black?style=for-the-badge&logo=github)

A console-based Banking System built using Core Java, JDBC, and MySQL, designed to simulate real-world banking operations such as user authentication, account management, and financial transactions.

This project demonstrates object-oriented design, database integration, and transaction-based logic, making it suitable for academic projects, interviews, and Java developer portfolios.


🔑 Key Highlights (For Recruiters)

- Implemented end-to-end JDBC–MySQL integration  
- Designed modular Java classes following OOP principles  
- Used AUTO_INCREMENT primary keys for safe account number generation  
- Implemented secure PIN-based transaction validation  
- Structured project for scalability and maintainability  
- Clear separation of concerns (User, Account, Transaction logic)


✨ Features

- User Registration & Login  
- Open New Bank Account  
- Deposit (Credit) Money  
- Withdraw (Debit) Money  
- Transfer Money Between Accounts  
- Check Account Balance  


🛠️ Technologies Used

- Java (JDK 17 / 22+)  
- JDBC (MySQL Connector/J)  
- MySQL Database  
- IntelliJ IDEA  
- Git & GitHub  


📂 Project Structure
```
banking_system_java/
├── BankingSystem.java
├── User.java
├── Accounts.java
├── AccountManager.java
├── databases/
│   └── banking_system.sql
└── README.md

```

---

## 🗄️ Database Details

### Database Name
```

banking_system

````

### Tables Used
- users  
- accounts  

---

## ⚙️ Database Setup

```sql
CREATE DATABASE banking_system;
USE banking_system;
SOURCE databases/banking_system.sql;
````

---

## 🔌 JDBC Configuration

Database connections are created directly inside the respective classes using:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/banking_system",
    "root",
    "your_password"
);
```

---

## ▶️ How to Run

1. Open the project in IntelliJ IDEA
2. Add MySQL Connector/J to the project libraries
3. Navigate to `BankingSystem.java`
4. Run the `main()` method

---

## 🖥️ Sample Console Menu

```
=== Welcome TO BANKING SYSTEM ===
1. Register
2. Login
3. Exit
```

After login:

```
1. Open New Bank Account
2. Debit Money
3. Credit Money
4. Transfer Money
5. Check Balance
6. Exit
```

---

## 🚀 What This Project Demonstrates

* Core Java and OOP concepts
* JDBC and MySQL integration
* SQL query execution from Java
* Real-world banking logic simulation
* Clean project structure

---

## ⚠️ Important Notes

* Passwords are stored in plain text (for learning purposes only)
* This project is not production-ready

---

## 👨‍💻 Author

**Mrinmoy Debnath** | 
**Java Learner**

---

## 📜 License

This project is licensed under the **MIT License**.
Free to use for learning and educational purposes.


