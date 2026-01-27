package Banking_System_JAVA;

import java.sql.*;
import java.util.*;

public class Accounts {
    private Connection con;
    private Scanner sc;
    public Accounts(Connection con, Scanner sc){
        this.con = con;
        this.sc = sc;
    }

    public long open_account(String email){
        if(!account_exist(email)){
            String open_account_query = "INSERT INTO accounts(account_number, full_name, email, balance, security_pin) VALUES(?, ?, ?, ?, ?)";
            sc.nextLine();
            System.out.println("Enter full Name: ");
            String full_name = sc.nextLine();
            System.out.println("Enter Initial Ammount: ");
            double balance = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter Security Pin: ");
            String security_pin = sc.nextLine();
            try{
                long account_number = generateAccountNumber();
                PreparedStatement prestmt = con.prepareStatement(open_account_query);
                prestmt.setLong(1, account_number);
                prestmt.setString(2, full_name);
                prestmt.setString(3, email);
                prestmt.setDouble(4,balance);
                prestmt.setString(5, security_pin);
                int rowsAffected = prestmt.executeUpdate();
                if(rowsAffected>0){
                    return account_number;
                } else{
                    throw new RuntimeException("Account Creation Failed..");
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        throw new RuntimeException("Account Already Exist..");
    }
    public long getAccount_number(String email) {
        String query = "SELECT account_number from Accounts WHERE email = ?";
        try{
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return resultSet.getLong("account_number");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        throw new RuntimeException("Account Number Doesn't Exist!");
    }

    private long generateAccountNumber() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT account_number FROM accounts ORDER BY account_number DESC LIMIT 1"
            );

            if (rs.next()) {
                long lastAccountNumber = rs.getLong("account_number");
                return lastAccountNumber + 1;
            } else {
                return 10000100;
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to generate account number", e);
        }
    }

    public boolean account_exist(String email){
        String query = "SELECT account_number FROM Accounts WHERE email = ?";
        try{
            PreparedStatement prestmt = con.prepareStatement(query);
            prestmt.setString(1, email);
            ResultSet rs = prestmt.executeQuery();
            if(rs.next()){
                return true;
            } else{
                return false;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
