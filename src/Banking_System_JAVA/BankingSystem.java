package Banking_System_JAVA;

import java.sql.*;
import java.util.Scanner;

public class BankingSystem {
    private static final String url = "jdbc:mysql://127.0.0.1:3306/banking_system";
    private static final String username = "root";
    private static final String password = "Mrinmoy@007";

    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            Scanner sc= new Scanner(System.in);
            User user = new User(con, sc);
            Accounts acc = new Accounts(con, sc);
            AccountManager accManager = new AccountManager(con, sc);

            String email;
            long acc_number;

            while(true){
                System.out.println("=== Welcome TO BANKING SYSTEM ===");
                System.out.println();
                System.out.println("1. Register: ");
                System.out.println("2. Login: ");
                System.out.println("3. Exit: ");
                System.out.println("Enter your choice: ");
                int choice1 = sc.nextInt();
                switch (choice1){
                    case 1:
                        user.register();
                        break;
                    case 2:
                        email = user.login();
                        if(email!=null){
                            System.out.println();
                            System.out.println("User Logged In!");
                            if(!acc.account_exist(email)){
                                System.out.println();
                                System.out.println("1. Open a new Bank Account");
                                System.out.println("2. Exit");
                                if(sc.nextInt() == 1) {
                                    acc_number = acc.open_account(email);
                                    System.out.println("Account Created Successfully");
                                    System.out.println("Your Account Number is: " + acc_number);
                                }else{
                                    break;
                                }

                            }
                            acc_number = acc.getAccount_number(email);
                            int choice2 = 0;
                            while (choice2 != 5) {
                                System.out.println();
                                System.out.println("1. Debit Money");
                                System.out.println("2. Credit Money");
                                System.out.println("3. Transfer Money");
                                System.out.println("4. Check Balance");
                                System.out.println("5. Log Out");
                                System.out.println("Enter your choice: ");
                                choice2 = sc.nextInt();
                                switch (choice2) {
                                    case 1:
                                        accManager.debit_money(acc_number);
                                        break;
                                    case 2:
                                        accManager.credit_money(acc_number);
                                        break;
                                    case 3:
                                        accManager.transfer_money(acc_number);
                                        break;
                                    case 4:
                                        accManager.getBalance(acc_number);
                                        break;
                                    case 5:
                                        break;
                                    default:
                                        System.out.println("Enter Valid Choice!");
                                        break;
                                }
                            }

                        }
                        else{
                            System.out.println("Incorrect Email or Password!");
                        }
                    case 3:
                        System.out.println("THANK YOU FOR USING BANKING SYSTEM!!!");
                        System.out.println("Exiting System!");
                        return;
                    default:
                        System.out.println("Enter Valid Choice");
                        break;
                }
            }
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
