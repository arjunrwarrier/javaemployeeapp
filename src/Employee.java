
import java.sql.*;
import java.util.Scanner;

public class Employee {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice, empcode, empsalary;
        String empname, empdes, compname, empemail, emppassword, empphone;



        while(true){
            System.out.println("Employee Management App");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search for a Employee");
            System.out.println("4. Update a Employee");
            System.out.println("5. Delete a Employee");
            System.out.println("6. Exit ");
            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Add Employee");
                    System.out.println("Enter the Employee code: ");
                    empcode = input.nextInt();
                    System.out.println("Enter Employee name: ");
                    empname = input.next();
                    System.out.println("Enter the designation: ");
                    empdes = input.next();
                    System.out.println("Enter the salary: ");
                    empsalary = input.nextInt();
                    System.out.println("Enter the Company name: ");
                    compname = input.next();
                    System.out.println("Enter the Phone Number: ");
                    empphone = input.next();
                    System.out.println("Enter the Email Id: ");
                    empemail = input.next();
                    System.out.println("Enter the password: ");
                    emppassword = input.next();

                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root","");
                        String sql = "INSERT INTO `employees`(`empcode`, `empname`, `designation`, `salary`, `companyname`, `phone`, `emailid`, `password`) VALUES (?,?,?,?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setInt(1,empcode);
                        stmt.setString(2,empname);
                        stmt.setString(3,empdes);
                        stmt.setInt(4,empsalary);
                        stmt.setString(5,compname);
                        stmt.setString(6,empphone);
                        stmt.setString(7,empemail);
                        stmt.setString(8,emppassword);
                        stmt.executeUpdate();


                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;

                case 2:
                    System.out.println("Viewl All Employees");
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                        String sql ="SELECT `empcode`, `empname`, `designation`, `salary`, `companyname`, `phone`, `emailid`, `password` FROM `employees` ";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            String fetchEmpCode = rs.getString("empcode");
                            String fetchEmpName = rs.getString("empname");
                            String fetchEmpDes = rs.getString("designation");
                            String fetchEmpSalary = rs.getString("salary");
                            String fetchCompName = rs.getString("companyname");
                            String fetchPhone = rs.getString("phone");
                            String fetchEmail = rs.getString("emailid");
                            String fetchPassword = rs.getString("password");
                            System.out.println("Employee Code: "+fetchEmpCode);
                            System.out.println("Employee Name: "+fetchEmpName);
                            System.out.println("Employee Designation: "+fetchEmpDes);
                            System.out.println("Employee Salary: "+fetchEmpSalary);
                            System.out.println("Employee CompanyName: "+fetchCompName);
                            System.out.println("Employee Phone Number: "+fetchPhone);
                            System.out.println("Employee Email Id: "+fetchEmail);
                            System.out.println("Employee Password: "+fetchPassword+"\n");

                        }
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;


                case 3:
                    System.out.println("Search for an Employee");
                    System.out.println("Enter the Employee code: ");
                    empcode = input.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                        String sql = "SELECT `empname`, `designation`, `salary`, `companyname`, `phone`, `emailid`, `password` FROM `employees` WHERE `empcode`="+String.valueOf(empcode);

                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while(rs.next()){
                            String fetchEmpName = rs.getString("empname");
                            String fetchEmpDes = rs.getString("designation");
                            String fetchEmpSalary = rs.getString("salary");
                            String fetchCompName = rs.getString("companyname");
                            String fetchPhone = rs.getString("phone");
                            String fetchEmail = rs.getString("emailid");

                            System.out.println("Employee Name: "+fetchEmpName);
                            System.out.println("Employee Designation: "+fetchEmpDes);
                            System.out.println("Employee Salary: "+fetchEmpSalary);
                            System.out.println("Employee CompanyName: "+fetchCompName);
                            System.out.println("Employee Phone Number: "+fetchPhone);
                            System.out.println("Employee Email Id: "+fetchEmail);

                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Update a Employee");
                    System.out.println("Enter the Employee code: ");
                    empcode = input.nextInt();
                    System.out.println("Enter Employee name to update: ");
                    empname = input.next();
                    System.out.println("Enter the designation to update: ");
                    empdes = input.next();
                    System.out.println("Enter the salary to update: ");
                    empsalary = input.nextInt();
                    System.out.println("Enter the Company name to update: ");
                    compname = input.next();
                    System.out.println("Enter the Phone Number to update: ");
                    empphone = input.next();
                    System.out.println("Enter the Email Id to update: ");
                    empemail = input.next();
                    System.out.println("Enter the password to update: ");
                    emppassword = input.next();

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb", "root", "");
                        String sql = "UPDATE `employees` SET `empname`='"+empname+"',`designation`='"+empdes+"',`salary`='"+empsalary+"',`companyname`='"+compname+"',`phone`='"+empphone+"',`emailid`='"+empemail+"',`password`='"+emppassword+"' WHERE `empcode` = "+String.valueOf(empcode);

                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Data updated successfully");
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("Delete an Employee");
                    System.out.println("Enter the employee code: ");
                    empcode = input.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","");
                        String sql ="DELETE FROM `employees` WHERE `empcode`="+String.valueOf(empcode);
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                        System.out.println("Employee Deleted from database successfully.");

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;


                case 6:
                    System.out.println("Exited Menu");
                    System.exit(0);






            }

        }
    }
}
