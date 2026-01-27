package Banking_System_JAVA;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class User {

    private Connection con;
    private Scanner sc;

    public User(Connection con, Scanner sc){
        this.con = con;
        this.sc = sc;
    }

    public void register(){
        sc.nextLine();
        System.out.println("Full Name: ");
        String full_name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.nextLine();
        System.out.println("Password: ");
        String password = sc.nextLine();
        if(user_exist(email)){
            System.out.println("User Already exists for this email address..");
            return;
        }
        String register_query = "INSERT INTO user(full_name,email, password) VALUES(?, ?, ?)";
        try{
            PreparedStatement prestmt = con.prepareStatement(register_query);
            prestmt.setString(1, full_name);
            prestmt.setString(2, email);
            prestmt.setString(3, password);
            int rowsAffected = prestmt.executeUpdate();
            if (rowsAffected>0){
                System.out.println("Registration Successful..");
            } else{
                System.out.println("Registration failed..");
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
    }

    public String login(){
        sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Password: ");
        String password = sc.nextLine();
        String login_query = "SELECT * FROM User WHERE email = ? AND password = ?";
        try{
            PreparedStatement preparedStatement = con.prepareStatement(login_query);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return email;
            }else{
                return null;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public boolean user_exist(String email){
        String query = "SELECT * FROM user WHERE email = ?";
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
